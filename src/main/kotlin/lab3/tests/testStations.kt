package lab3

fun testStations() {
    Statistics.resetStats()

    val electricStation = ElectricStation()
    val gasStation = GasStation()
    val peopleDinner = PeopleDinner()
    val robotDinner = RobotDinner()

    electricStation.refuel(1)
    gasStation.refuel(2)
    gasStation.refuel(3)
    peopleDinner.serveDinner(2)
    robotDinner.serveDinner(3)
    electricStation.refuel(4)
    robotDinner.serveDinner(1)

    Statistics.printStats()

    assert(Statistics.electricCars == 2) { "Expected 2 electric cars, but found ${Statistics.electricCars}" }
    assert(Statistics.gasCars == 2) { "Expected 2 gas cars, but found ${Statistics.gasCars}" }
    assert(Statistics.peopleCount == 1) { "Expected 1 dinner served to people, but found ${Statistics.peopleCount}" }
    assert(Statistics.robotCount == 2) { "Expected 2 dinners served to robots, but found ${Statistics.robotCount}" }
}
