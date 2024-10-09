package lab1

class UniverseContainer {
    private val universes: MutableList<UniverseWithPlanets> = mutableListOf()

    fun addUniverseWithPlanets(universe: Universe, planets: Planets) {
        universes.add(UniverseWithPlanets(universe.name, planets.planets.joinToString(", ")))
    }

    fun displayUniverses() {
        universes.forEach {
            println("Universe: ${it.universeName}")
            println("Planets: ${it.planets}")
            println()
        }
    }
}

data class UniverseWithPlanets(val universeName: String, val planets: String)