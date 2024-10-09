package lab1

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.io.File

fun main() {
    // Variables for reading a file
    val objectMapper = ObjectMapper()
    val jsonFilePath = "src/main/resources/test-input.json"
    val jsonFileReader = JsonFileReader(jsonFilePath)
    val dataNodes = jsonFileReader.readJsonFile()
    jsonFileReader.readJsonFile()

    // Variables to realize the main logic of verification
    val universeContainer = UniverseContainer()

    val marvelPlanets  = Planets(arrayOf("Asgard"))
    val hitchHikerPlanets = Planets(arrayOf("Betelgeuse", "Vogsphere"))
    val starwarsPlanets = Planets(arrayOf("Kashyyyk", "Endor"))
    val ringsPlanets = Planets(arrayOf(""))

    val starWars = Universe("starWars", mutableListOf())
    val hitchHiker = Universe("hitchHiker", mutableListOf())
    val rings = Universe("rings", mutableListOf())
    val marvel = Universe("marvel", mutableListOf())

    universeContainer.addUniverseWithPlanets(marvel, marvelPlanets)
    universeContainer.addUniverseWithPlanets(starWars, starwarsPlanets)
    universeContainer.addUniverseWithPlanets(hitchHiker, hitchHikerPlanets)
    universeContainer.addUniverseWithPlanets(rings, ringsPlanets)

    universeContainer.displayUniverses()

    // Working with every object of the JSON file
    dataNodes.forEach { node ->
        println(node)
        val planetName = node.get("planet")?.asText()
        if (planetName != null) {
            when {
                marvelPlanets.planets.contains(planetName) -> {
                    println("This planet is from Marvel universe: $planetName")
                    marvel.individuals.add(node)
                }
                starwarsPlanets.planets.contains(planetName) -> {
                    println("This planet is from Star Wars universe: $planetName")
                    starWars.individuals.add(node)
                }
                hitchHikerPlanets.planets.contains(planetName) -> {
                    println("This planet is from Hitchhiker universe: $planetName")
                    hitchHiker.individuals.add(node)
                }
                ringsPlanets.planets.contains(planetName) -> {
                    println("This planet is from Rings universe: $planetName")
                    rings.individuals.add(node)
                }
            }
        }
        when (readlnOrNull()) {
            "1" -> starWars.individuals.add(node)
            "2" -> hitchHiker.individuals.add(node)
            "3" -> rings.individuals.add(node)
            "4" -> marvel.individuals.add(node)
        }
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