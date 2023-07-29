package utility

import android.graphics.Color
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.FolderOverlay
import org.osmdroid.views.overlay.Polyline
import org.w3c.dom.Document
import roomdb.Pista

data class OSMWayTag (val k: String, val v: String)
data class OSMWay (val id: Long, val nodesId: List<Long>, val tags: List<OSMWayTag>)
data class OSMNode (val id: Long, val lat: Double, val long: Double)

class OsmXmlAnalyzer {
    private fun getWays(document: Document): MutableList<OSMWay> {
        val ways = mutableListOf<OSMWay>()

        val wayNodes = document.getElementsByTagName("way")
        for (i in 0 until wayNodes.length) {
            val wayNode = wayNodes.item(i)
            val wayId = wayNode.attributes.getNamedItem("id").nodeValue.toLong()

            val ndNodes = wayNode.childNodes
            val nodeIds = mutableListOf<Long>()
            val nodeTags = mutableListOf<OSMWayTag>()

            for (j in 0 until ndNodes.length) {
                val ndNode = ndNodes.item(j)
                if (ndNode.nodeName == "nd") {
                    val nodeId = ndNode.attributes.getNamedItem("ref").nodeValue.toLong()
                    nodeIds.add(nodeId)
                }
                if (ndNode.nodeName == "tag") {
                    val k = ndNode.attributes.getNamedItem("k").nodeValue
                    val v = ndNode.attributes.getNamedItem("v").nodeValue
                    nodeTags.add(OSMWayTag(k, v))
                }
            }

            val way = OSMWay(wayId, nodeIds, nodeTags)
            ways.add(way)
        }

        return ways
    }

    private fun getNodes(document: Document): MutableList<OSMNode> {
        val nodes = mutableListOf<OSMNode>()

        val nodeNodes = document.getElementsByTagName("node")
        for (i in 0 until nodeNodes.length) {
            val nodeElement = nodeNodes.item(i)

            val nodeId = nodeElement.attributes.getNamedItem("id").nodeValue.toLong()
            val nodeLat = nodeElement.attributes.getNamedItem("lat").nodeValue.toDouble()
            val nodeLong = nodeElement.attributes.getNamedItem("lon").nodeValue.toDouble()

            nodes.add(OSMNode(nodeId, nodeLat, nodeLong))
        }

        return nodes
    }

    fun getPistaList(document: Document, comprensorioId: Int): ArrayList<Pista> {
        val ways = this.getWays(document)
        val listaPiste = ArrayList<Pista>()

        for (way in ways) {
            val wayTags = way.tags
            var difficulty = "no"
            var nome = "no"

            for (tag in wayTags) {
                if (tag.k == "piste:difficulty")
                    difficulty = tag.v
                else if (tag.k == "piste:name" || tag.k == "name")
                    nome = tag.v
            }

            if (nome != "no" && difficulty != "no") {
                val pista = Pista(way.id.toInt(), nome, difficulty, comprensorioId)
                listaPiste.add(pista)
            }
        }

        return listaPiste
    }

    fun getSkiAreaOverlay(document: Document): FolderOverlay {
        // ottengo i ways (le piste) e i nodes (i punti che le compongono)
        val ways = this.getWays(document)
        val nodes = this.getNodes(document)
        val overlays = FolderOverlay()

        // per ogni way, ottengo le coordinate dei suoi nodi, e per ognuno di questi creo un GeoPoint
        for (way in ways) {
            val geoPoints = ArrayList<GeoPoint>()

            for (wayNodeId in way.nodesId) {
                val node = this.findNodeById(nodes, wayNodeId)
                if (node != null)
                    geoPoints.add(GeoPoint(node.lat, node.long))
            }

            var polyline = Polyline()
            for (point in geoPoints)
                polyline.addPoint(point)

            val wayDifficultyTag = getDifficultyFromWayTags(way.tags)
            if (wayDifficultyTag != null)
                polyline = this.polyLineColor(wayDifficultyTag.v, polyline)

            overlays.add(polyline)
        }

        return overlays
    }

    private fun findNodeById(nodes: MutableList<OSMNode>, nodeId: Long): OSMNode? {
        return nodes.find { it.id == nodeId }
    }

    private fun getDifficultyFromWayTags(wayTags: List<OSMWayTag>): OSMWayTag? {
        return wayTags.find { it.k == "piste:difficulty" }
    }

    private fun polyLineColor(diff: String, poly: Polyline): Polyline {
        when (diff) {
            "easy" -> poly.color = Color.BLUE
            "intermediate" -> poly.color = Color.RED
            "advanced" -> poly.color = Color.BLACK
        }

        return poly
    }
}