package lab1

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.io.File

fun main() {
    val objectMapper = ObjectMapper()
    val jsonFilePath = "src/main/resources/test-input.json"
    val jsonFileReader = JsonFileReader(jsonFilePath)
    val dataNodes = jsonFileReader.readJsonFile()
    jsonFileReader.readJsonFile()

    val marvelPlanets  = Planets(arrayOf("Asgard"))
    val hitchHikerPlanets = Planets(arrayOf("Betelgeuse", "Vogsphere"))
    val starwarsPlanets = Planets(arrayOf("Kashyyyk", "Endor"))

    println(marvelPlanets.planets.contentToString())
    println(hitchHikerPlanets.planets.contentToString())
    println(starwarsPlanets.planets.contentToString())

    val starWars = Universe("starWars", mutableListOf())
    val hitchHiker = Universe("hitchHiker", mutableListOf())
    val rings = Universe("rings", mutableListOf())
    val marvel = Universe("marvel", mutableListOf())

    dataNodes.forEach { node ->
        println(node)
        /*
        when (readlnOrNull()) {
            "1" -> starWars.individuals.add(node)
            "2" -> hitchHiker.individuals.add(node)
            "3" -> rings.individuals.add(node)
            "4" -> marvel.individuals.add(node)
        }
        */
    }
    /*
    File("src/main/resources/output/starwars.json").writeText(objectMapper.writeValueAsString(starWars))
    File("src/main/resources/output/hitchhiker.json").writeText(objectMapper.writeValueAsString(hitchHiker))
    File("src/main/resources/output/rings.json").writeText(objectMapper.writeValueAsString(rings))
    File("src/main/resources/output/marvel.json").writeText(objectMapper.writeValueAsString(starWars))
    */
}

data class Universe(val name: String, val individuals: MutableList<JsonNode>)
class Planets(var planets: Array<String>)