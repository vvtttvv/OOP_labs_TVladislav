package lab1

object UniverseData {
    // All races
    private val wookie = Creatures(isHumanoid = false, planet = "Kashyyyk", age = 400, traits = listOf("TALL", "HAIRY"))
    private val ewok = Creatures(isHumanoid = false, planet = "Endor", age = 60, traits = listOf("SHORT", "HAIRY"))
    private val asgardian = Creatures(isHumanoid = true, planet = "Asgard", age = 5000, traits = listOf("BLONDE", "TALL"))
    private val betelgeusian = Creatures(isHumanoid = true, planet = "Betelgeuse", age = 100, traits = listOf("EXTRA_ARMS", "EXTRA_HEAD"))
    private val vogons = Creatures(isHumanoid = false, planet= "Vogsphere", age = 200, traits = listOf("GREEN", "BULKY"))
    private val elf = Creatures(isHumanoid = true, planet = "Earth", age = 100000000, traits = listOf("BLONDE", "POINTY_EARS"))
    private val dwarf = Creatures(isHumanoid = true, planet = "Earth", age = 200, traits = listOf("SHORT", "BULKY"))

    // All universes
    val starWars = Universe("starWars", mutableListOf())
    val hitchHiker = Universe("hitchHiker", mutableListOf())
    val rings = Universe("rings", mutableListOf())
    val marvel = Universe("marvel", mutableListOf())

    // All races are included in universes
    val belongings = listOf(
        Belonging(starWars, listOf(wookie, ewok)),
        Belonging(hitchHiker, listOf(vogons, betelgeusian)),
        Belonging(rings, listOf(elf, dwarf)),
        Belonging(marvel, listOf(asgardian))
    )
}
