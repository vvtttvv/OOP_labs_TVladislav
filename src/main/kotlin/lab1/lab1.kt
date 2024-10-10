package lab1

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File

fun main() {
    // Variables for reading a file
    val objectMapper = ObjectMapper()
    //Change to your file for testing
    val jsonFilePath = "src/main/resources/input.json"
    val jsonFileReader = JsonFileReader(jsonFilePath)
    val dataNodes = jsonFileReader.readJsonFile()

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

    // Working with every object of the JSON file
    dataNodes.forEach { node ->
        println(node)
        val planetName = node.get("planet")?.asText()
        val isHumanoid = node.get("isHumanoid")?.asBoolean() ?: false
        val traits = node.get("traits")?.map { it.asText() }
        val age = node.get("age")?.asInt()

        // Creating Node object
        val individual = Node(isHumanoid, planetName, age, traits)

        // Here I implemented checking for planets, because we have specific planets for universes
        if (individual.planetName != null) {
            when {
                universeContainer.getPlanetsByUniverse("marvel")?.contains(planetName) == true -> {
                    println("This planet is from Marvel universe: $planetName")
                    marvel.individuals.add(node)
                    return@forEach
                }
                universeContainer.getPlanetsByUniverse("starWars")?.contains(planetName) == true -> {
                    println("This planet is from Star Wars universe: $planetName")
                    starWars.individuals.add(node)
                    return@forEach
                }
                universeContainer.getPlanetsByUniverse("hitchHiker")?.contains(planetName) == true -> {
                    println("This planet is from Hitchhiker universe: $planetName")
                    hitchHiker.individuals.add(node)
                    return@forEach
                }
            }
        }
        //Here I check traits
        if (individual.traits != null) {
            if (individual.traits.contains("HAIRY")) {
                println("This creature is wookie!")
                starWars.individuals.add(node)
                return@forEach
            } else if (individual.traits.contains("BLONDE") && individual.traits.contains("TALL")) {
                println("This is TOR!")
                marvel.individuals.add(node)
                return@forEach
            } else if ((individual.traits.contains("EXTRA_HEAD") || individual.traits.contains("EXTRA_ARMS"))||(individual.traits.contains("BULKY"))){
                println("Idk nothing about Hitchhiker's Guide to the Galaxy but as I understand it is from here")
                hitchHiker.individuals.add(node)
                return@forEach
            } else if (!isHumanoid && individual.traits.contains("GREEN")){
                println("It can be baby Yoda!")
                starWars.individuals.add(node)
                return@forEach
            }
        }
        // Here I check some other combinations
        if (individual.isHumanoid && individual.age != null && individual.age>1000 || (traits != null && traits.contains("POINTY_EARS"))) {
            println("It's Legolas!")
            rings.individuals.add(node)
            return@forEach
        }
    }

    // Saving the files with pretty printing
    File("src/main/resources/output/starwars.json").writeText(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(starWars))
    File("src/main/resources/output/hitchhiker.json").writeText(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(hitchHiker))
    File("src/main/resources/output/rings.json").writeText(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rings))
    File("src/main/resources/output/marvel.json").writeText(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(marvel))


}

class Node (
    val isHumanoid: Boolean,
    val planetName: String?,
    val age: Int?,
    val traits: List<String>?
)

data class Universe(val name: String, val individuals: MutableList<JsonNode>)
class Planets(var planets: Array<String>)