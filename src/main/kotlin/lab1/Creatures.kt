package lab1

import com.fasterxml.jackson.databind.JsonNode

//For already known races
class Creatures(
    val isHumanoid: Boolean,
    val planet: String,
    val age: Int,
    val traits: List<String>
)

//To get current node
class Node (
    val isHumanoid: Boolean?,
    val planetName: String?,
    val age: Int?,
    val traits: List<String>?
)

//To show store each universe with its races
class Belonging(
    val universe: Universe,
    val races: List<Creatures>
)
