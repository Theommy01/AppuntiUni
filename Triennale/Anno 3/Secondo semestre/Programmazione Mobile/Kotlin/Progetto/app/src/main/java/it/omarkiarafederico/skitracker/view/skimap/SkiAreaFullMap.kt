package it.omarkiarafederico.skitracker.view.skimap

import org.json.JSONObject
import org.w3c.dom.Document
import org.xml.sax.InputSource
import utility.ApiCallException
import utility.ApiCallThread
import javax.xml.parsers.DocumentBuilderFactory

class SkiAreaFullMap {
    /*
    Dati le coordinate del comprensorio e il livello di precisione dell'ottenimento dei punti (zoom),
    ritorno un documento KML che rappresenta tutti i punti delle piste del comprensorio.

    Il livello di zoom è un valore compreso tra 1 e 18 che indica la precisione con cui vanno ottenuti
    i punti della mappa. Usando il valore 1 si avrebbe alta imprecisione (si farebbe una ricerca a
    livello nazionale), con 18 si avrebbe una precisione estrema (si prenderebbero i punti che
    giacciono esattamente sul punto indicato dalle coordinate).
     */
    @Throws(ApiCallException::class)
    fun ottieniXmlMappaComprensorio(lat: Double, long: Double, zoomLevel: Int): Document {
        // vado a ottenere il JSON che contiene le informazioni geografiche del comprensorio
        // in particolar modo, mi serviranno sapere le coordinate in cui la sua area è compresa
        val skiAreaGeocodedText = ApiCallThread()
            .main("https://nominatim.openstreetmap.org/reverse?lat=${lat}&lon=${long}&format=geojson&extratags=1&zoom=${zoomLevel}")
        val skiAreaGeocodedJson = JSONObject(skiAreaGeocodedText)

        // ottengo le coordinate dell'area del comprensorio
        val skiAreaFeatures = skiAreaGeocodedJson.getJSONArray("features")[0] as JSONObject
        val skiAreaBbox = skiAreaFeatures.getJSONArray("bbox")
        val skiAreaW = skiAreaBbox[0]
        val skiAreaS = skiAreaBbox[1]
        val skiAreaE = skiAreaBbox[2]
        val skiAreaN = skiAreaBbox[3]

        // questo è l'XML della richiesta da fare a Overpass per ottenere la mappa completa del
        // comprensorio, comprendente le piste, che verrà ritornata in formato OpenStreetMap XML.
        val requestBody = composeOverpassRequest(skiAreaW as Double,
            skiAreaS as Double, skiAreaE as Double, skiAreaN as Double)

        val skiAreaOsmString = ApiCallThread().callWithXmlArgument(
            requestBody,
            "https://overpass-api.de/api/interpreter"
        )

        // Converto l'osm xml ricevuto come stringa in un documento XML
        return convertStringToXmlDocument(skiAreaOsmString)
    }

    /*
    Questo funzione ottiene la richiesta in XML che deve essere fornita all'API Overpass, che serve
    ad ottenere i punti delle mappe usando OpenStreetMap.
    In questo caso, queste sono le istruzioni utili a ottenere le piste del comprensorio compreso
    nelle coordinate che sono state fornite.
     */
    private fun composeOverpassRequest(
        skiAreaW: Double, skiAreaS: Double, skiAreaE: Double,
        skiAreaN: Double
    ): String {

        return "" +
                "<osm-script output=\"xml\" timeout=\"25\">" +
                "   <union>" +
                "       <query type=\"way\">" +
                "           <has-kv k=\"piste:type\" />" +
                "           <bbox-query w=\"$skiAreaW\" s=\"$skiAreaS\" e=\"$skiAreaE\" n=\"$skiAreaN\" />" +
                "       </query>" +
                "   </union>" +
                "   <print mode=\"body\" />" +
                "   <recurse type=\"down\" />" +
                "   <print mode=\"skeleton\" order=\"quadtile\" />" +
                "</osm-script>"
    }

    private fun convertStringToXmlDocument(xmlString: String): Document {
        val factory = DocumentBuilderFactory.newInstance()
        val builder = factory.newDocumentBuilder()
        val inputSource = InputSource(xmlString.reader())
        return builder.parse(inputSource)
    }
}