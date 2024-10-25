package lab0

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File

class JsonFileReader() {
    private val objectMapper: ObjectMapper = ObjectMapper()

    fun readJsonFile(path: String, node: String): List<JsonNode> {
        val file = File(path)
        val jsonNode = objectMapper.readTree(file)
        println("File read successfully.")
        return jsonNode[node].map { it }
    }
}
