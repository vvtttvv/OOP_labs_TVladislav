package lab3

object Statistics {
    var electricCars = 0
    var gasCars = 0
    var peopleCount = 0
    var robotCount = 0

    fun incrementElectricCarCount() {
        electricCars++
    }

    fun incrementGasCarCount() {
        gasCars++
    }

    fun incrementPeopleCount() {
        peopleCount++
    }

    fun incrementRobotCount() {
        robotCount++
    }

    fun printStats() {
        println("Statistics:")
        println("Electric cars served: $electricCars")
        println("Gas cars served: $gasCars")
        println("Dinners served to people: $peopleCount")
        println("Dinners served to robots: $robotCount")
    }

    fun resetStats() {
        electricCars = 0
        gasCars = 0
        peopleCount = 0
        robotCount = 0
    }
}
