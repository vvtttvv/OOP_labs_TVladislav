package lab1

import com.fasterxml.jackson.databind.JsonNode

data class Universe(
    val name: String,
    val individuals: MutableList<JsonNode>
)