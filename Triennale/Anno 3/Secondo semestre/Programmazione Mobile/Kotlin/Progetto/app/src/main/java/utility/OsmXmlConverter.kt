/*************************************************************************************************
 * OpenStreetMap XML Converter
 * Questa classe offre metodi per convertire gli XML per rappresentare le mappe di OpenStreetMap
 * in altri sistemi di rappresentazione (es.: GeoJSON).
 ************************************************************************************************/
package utility

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.module.kotlin.readValue
import org.w3c.dom.Document
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory

class OsmXmlConverter {
    /*
    Converte un OSM XML in un GeoJSON, formato di rappresentazione dei punti di una mappa basato su
    JSON.
    I vari punti della mappa (in questo caso, i punti che costituiscono le piste del comprensorio,
    vengono rappresentati all'interno di un contenitore, chiamato Features.
     */
    fun toGeoJson(osmXml: String): String {
        val docFactory = DocumentBuilderFactory.newInstance()
        val dBuilder = docFactory.newDocumentBuilder()
        val xmlInput = InputSource(StringReader(osmXml))
        val doc: Document = dBuilder.parse(xmlInput)

        val objectMapper = ObjectMapper()
        val geoJson = objectMapper.createObjectNode()

        geoJson.put("type", "FeatureCollection")
        val features = objectMapper.createArrayNode()

        val nodes = doc.getElementsByTagName("node")
        for (i in 0 until nodes.length) {
            val node = nodes.item(i)
            val feature = objectMapper.createObjectNode()
            feature.put("type", "Feature")
            feature.put("id", node.attributes.getNamedItem("id").nodeValue)
            feature.putPOJO("geometry",
                objectMapper.readValue("{\"type\": \"Point\", \"coordinates\": [${node.attributes.getNamedItem("lon").nodeValue}, ${node.attributes.getNamedItem("lat").nodeValue}] }"))
            features.add(feature)
        }

        geoJson.set<ArrayNode>("features", features)
        return geoJson.toString()
    }

}