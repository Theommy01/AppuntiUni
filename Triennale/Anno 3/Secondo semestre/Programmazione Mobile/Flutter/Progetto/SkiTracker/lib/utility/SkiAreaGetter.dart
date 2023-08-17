import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:xml/xml.dart' as xml;

class SkiAreaGetter {
  Future<xml.XmlDocument> getSkiAreaXML(double latitudine, double longitudine, int zoomLevel) async {
    // ottengo il JSON che contiene l'area di inclusione del comprensorio
    var skiAreaGeocodeString = await this.getGeocodedArea(latitudine, longitudine, zoomLevel);
    var skiAreaGeocodeJSON = jsonDecode(skiAreaGeocodeString);

    // Ottengo le coordinate dell'area del comprensorio
    var skiAreaFeatures = skiAreaGeocodeJSON["features"];
    var skiAreaBbox = skiAreaFeatures[0]["bbox"];
    var skiAreaW = skiAreaBbox[0];
    var skiAreaS = skiAreaBbox[1];
    var skiAreaE = skiAreaBbox[2];
    var skiAreaN = skiAreaBbox[3];

    // ottengo l'OSM XML del comprensorio
    String requestBody = this.composeOverpassRequest(skiAreaW, skiAreaS, skiAreaE, skiAreaN);
    return this.getOpenStreetMapXML(requestBody);
  }

  Future<String> getGeocodedArea(double lat, double long, int zoom) async {
    var client = http.Client();
    var requestURI = Uri.parse("https://nominatim.openstreetmap.org/reverse?lat=${lat}&lon=${long}&format=geojson&extratags=1&zoom=${zoom}");
    var response = await client.get(requestURI);
    return response.body;
  }

  Future<xml.XmlDocument> getOpenStreetMapXML(String overpassXML) async {
    var client = http.Client();
    var requestURI = Uri.parse("https://overpass-api.de/api/interpreter");
    var response = await client.post(requestURI, headers: {'Content-Type': 'text/xml'}, body: overpassXML);
    return xml.XmlDocument.parse(response.body);
  }

  String composeOverpassRequest(double skiAreaW, double skiAreaS, double skiAreaE, double skiAreaN) {
    return "" +
        "<osm-script output=\"xml\" timeout=\"25\">" +
        "   <union>" +
        "       <query type=\"way\">" +
        "           <has-kv k=\"piste:type\" />" +
        "           <bbox-query w=\"${skiAreaW}\" s=\"${skiAreaS}\" e=\"${skiAreaE}\" n=\"${skiAreaN}\" />" +
        "       </query>" +
        "   </union>" +
        "   <print mode=\"body\" />" +
        "   <recurse type=\"down\" />" +
        "   <print mode=\"skeleton\" order=\"quadtile\" />" +
        "</osm-script>";
  }
}