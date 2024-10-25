package lab0

import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File

fun main() {
    val jsonFileReader = JsonFileReader()
    val dataNodes = jsonFileReader.readJsonFile("src/main/resources/input.json", "input")

    // Accessing races and universes from the UniverseData object
    val belongings = UniverseData.belongings

    // Working with every object of the JSON file
    dataNodes.forEach { node ->
        val planetName = node.get("planet")?.asText()
        val isHumanoid = node.get("isHumanoid")?.asBoolean()
        val traits = node.get("traits")?.map { it.asText() }
        val age = node.get("age")?.asInt()
        val individual = Individual(isHumanoid, planetName, age, traits)

        // Check to which universe the individual belongs
        val matchedBelonging = belongings.find {
            belonging -> belonging.races.any { race -> CreatureMatcher.matches(race, individual) }
        }

        // Add the individual to the corresponding universe if a match is found
        matchedBelonging?.universe?.individuals?.add(node)
    }

    // Saving the files with pretty printing
    val objectMapper = ObjectMapper()
    File("src/main/resources/output/starwars.json").writeText(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(UniverseData.starWars))
    File("src/main/resources/output/hitchhiker.json").writeText(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(UniverseData.hitchHiker))
    File("src/main/resources/output/rings.json").writeText(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(UniverseData.rings))
    File("src/main/resources/output/marvel.json").writeText(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(UniverseData.marvel))
    println("Saved successfully")
}