package lab3

object Statistics {
    var electricCars = 0
    var gasCars = 0
    var peopleCount = 0
    var robotCount = 0
    var totalDining = 0
    var totalNotDining = 0
    var gasConsumption = 0
    var electricConsumption = 0
    var robots = 0
    var people = 0

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

    fun incrementGasConsumption(consumption: Int){
        gasConsumption += consumption
    }

    fun incrementElectricConsumption(consumption: Int){
        electricConsumption += consumption
    }

    fun incrementPassengers(passengers: String){
        when (passengers) {
            "PEOPLE" -> {
                people++
            }
            "ROBOTS" -> {
                robots++
            }
        }
    }

    fun printStats() {
        println("\nStatistics:")
        println("Electric cars served: $electricCars")
        println("Gas cars served: $gasCars")
        println("Dinners served to people: $peopleCount")
        println("Dinners served to robots: $robotCount")
        totalDining = peopleCount+robotCount
        println("Total dining: $totalDining")
        totalNotDining = electricCars+gasCars - totalDining
        println("Total not dining: $totalNotDining")
        println("Gas consumption: $gasConsumption")
        println("Electric consumption: $electricConsumption")
        println("Robots: $robots")
        println("People: $people\n")
    }

    fun resetStats() {
        electricCars = 0
        gasCars = 0
        peopleCount = 0
        robotCount = 0
        totalDining = 0
        totalNotDining = 0
        gasConsumption = 0
        electricConsumption = 0
        robots = 0
        people = 0
    }
}
