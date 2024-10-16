package lab1

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File

class JsonFileReader() {
    private val jsonFilePath = "src/main/resources/input.json"
    private val objectMapper: ObjectMapper = ObjectMapper()
    private val file = File(jsonFilePath)

    fun readJsonFile(): List<JsonNode> {
        val jsonNode = objectMapper.readTree(file)
        println("File read successfully.")
        return jsonNode["input"].map { it }
    }
}
