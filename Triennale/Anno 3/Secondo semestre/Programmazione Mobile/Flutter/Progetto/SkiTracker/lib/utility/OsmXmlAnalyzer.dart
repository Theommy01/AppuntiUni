import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong2/latlong.dart';
import 'package:xml/xml.dart' as xml;
import '../models/Pista.dart';

/*++++++++++++++++++++++++++++++++++ CLASSI PER DEFINIZIONE DEI DATI ++++++++++++++++++++++++++++++++++*/
class OSMWayTag {
  late String k;
  late String v;

  OSMWayTag(String k, String v) {
    this.k = k;
    this.v = v;
  }
}

class OSMWay {
  late int id;
  late List<int> nodesId;
  late List<OSMWayTag> tags;

  OSMWay(int id, List<int> nodesId, List<OSMWayTag> tags) {
    this.id = id;
    this.nodesId = nodesId;
    this.tags = tags;
  }
}

class OSMNode {
  late int id;
  late double lat;
  late double long;

  OSMNode(int id, double lat, double long) {
    this.id = id;
    this.lat = lat;
    this.long = long;
  }
}

/*+++++++++++++++++++++++++++++++++++++++++ CLASSE STESSA PER L'ANALISI DEL XML DI OPENSTREETMAP +++++++++++++++++++++++++++*/
class OsmXmlAnalyzer {

  // Ottiene gli elementi Way da un documento OSM XML.
  List<OSMWay> getWays(xml.XmlDocument document) {
    List<OSMWay> ways = [];

    var wayNodes = document.findAllElements("way");
    for (var i = 0; i < wayNodes.length; i++) {
      var wayNode = wayNodes.elementAt(i);
      int wayId = int.parse(wayNode.getAttribute("id")!);

      var ndNodes = wayNode.childElements;
      List<int> nodeIds = [];
      List<OSMWayTag> nodeTags = [];

      for (var j = 0; j < ndNodes.length; j++) {
        var ndNode = ndNodes.elementAt(j);
        if (ndNode.name.toString() == "nd") {
          int nodeId = int.parse(ndNode.getAttribute("ref")!);
          nodeIds.add(nodeId);
        }
        if (ndNode.name.toString() == "tag") {
          String? k = ndNode.getAttribute("k");
          String? v = ndNode.getAttribute("v");
          nodeTags.add(OSMWayTag(k!, v!));
        }
      }

      OSMWay way = OSMWay(wayId, nodeIds, nodeTags);
      ways.add(way);
    }

    return ways;
  }

  // Ottiene i Nodes che compongono i Ways di un documento OSM XML.
  List<OSMNode> getNodes(xml.XmlDocument document) {
    List<OSMNode> nodes = [];

    var nodeNodes = document.findAllElements("node");
    for (int i = 0; i < nodeNodes.length; i++) {
      var nodeElement = nodeNodes.elementAt(i);

      int nodeId = int.parse(nodeElement.getAttribute("id")!);
      double nodeLat = double.parse(nodeElement.getAttribute("lat")!);
      double nodeLong = double.parse(nodeElement.getAttribute("lon")!);

      nodes.add(OSMNode(nodeId, nodeLat, nodeLong));
    }

    return nodes;
  }

  // Estrae da un documento OSM XML l'elenco di piste di un comprensorio.
  List<Pista> getPisteList(xml.XmlDocument document, int comprensorioId) {
    var ways = this.getWays(document);
    List<Pista> listaPiste = [];

    for (var way in ways) {
      List<OSMWayTag> wayTags = way.tags;
      String difficulty = "no";
      String nome = "no";

      for (var tag in wayTags) {
        if (tag.k == "piste:difficulty")
          difficulty = tag.v;
        else if (tag.k == "piste:name" || tag.k == "name")
          nome = tag.v;
      }

      if (nome != "no" && difficulty != "no") {
        Pista p = Pista(nome, difficulty, way.id, comprensorioId);
        listaPiste.add(p);
      }
    }

    listaPiste = this.removeDuplicatePistas(listaPiste);
    return listaPiste;
  }

  // Ottiene le Polylines che compongono le varie piste del comprensorio.
  List<Polyline> getSkiAreaPolylines(xml.XmlDocument document) {
    // ottengo i ways (le piste) e i nodes (i punti che le compongono)
    List<OSMWay> ways = this.getWays(document);
    List<OSMNode> nodes = this.getNodes(document);
    List<Polyline> polylines = [];

    // per ogni way, ottengo le coordinate dei suoi nodi, e per ognuno di questi creo un punto
    for (OSMWay way in ways) {
      List<LatLng> points = [];

      for (var wayNodeId in way.nodesId) {
        var node = this.findNodeById(nodes, wayNodeId);
        points.add(LatLng(node.lat, node.long));
      }

      // NOTA: firstWhere, usato in getDifficultyFromWayTags solleva uno StateError nel caso l'elemento
      // non venga trovato; quando arrivano ways senza tag Difficulty gestisco l'eccezione semplicemente non
      // aggiungendo alcuna polyline.
      try {
        OSMWayTag difficultyTag = getDifficultyFromWayTags(way.tags);
        Polyline polyline = Polyline(points: points,
            color: this.getPolylineColor(difficultyTag.v),
            strokeWidth: 3.5);

        polylines.add(polyline);
      } on StateError catch (_) {}
    }

    return polylines;
  }

  // Rimuove dalla lista di piste quelle che hanno lo stesso nome di altre. Se viene trovata una pista che ha lo stesso nome, quella inserita
  // precedentemente viene sostituita con la nuova occorrenza.
  List<Pista> removeDuplicatePistas(List<Pista> originalList) {
    List<String> nomiUsati = [];
    List<Pista> output = [];

    for (var i = 0; i < originalList.length; i++) {
      String nome = originalList[i].nome;
      if (!nomiUsati.contains(nome)) {
        output.add(originalList[i]);
        nomiUsati.add(nome);
      } else {
        for (int j = 0; j < output.length; j++) {
          if (output[j].nome == nome) {
            output[j] = originalList[i];
          }
        }
      }
    }

    return output;
  }

  // Trova ed estrae un nodo che appartiene alla lista dei nodi.
  OSMNode findNodeById(List<OSMNode> nodes, int nodeId) {
    return nodes.firstWhere((element) => element.id == nodeId);
  }

  // va ad estrapolare il tag "Difficulty" tra i vari tag presenti per un Way.
  OSMWayTag getDifficultyFromWayTags(List<OSMWayTag> wayTags) {
    return wayTags.firstWhere((element) => element.k == "piste:difficulty");
  }

  // imposta il colore della polyline in base alla difficoltà
  Color getPolylineColor(String diff) {
    Color output = Colors.yellow;

    switch(diff) {
      case 'novice':
        output = Colors.white; break;
      case 'easy':
        output = Colors.blue; break;
      case 'intermediate':
        output = Colors.red; break;
      case 'advanced':
        output = Colors.black; break;
    }

    return output;
  }
}