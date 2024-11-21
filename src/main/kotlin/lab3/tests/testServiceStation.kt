package lab3

fun testServiceStation() {
    val electricStation = ElectricStation()
    val gasStation = GasStation()
    val peopleDinner = PeopleDinner()
    val robotDinner = RobotDinner()

    electricStation.refuel("1")
    electricStation.refuel("2")
    gasStation.refuel("3")

    peopleDinner.serveDinner("1")
    robotDinner.serveDinner("2")
    peopleDinner.serveDinner("3")

    Statistics.printStats()

    assert(Statistics.electricCars == 2) { "Electric car count should be 2" }
    assert(Statistics.gasCars == 1) { "Gas car count should be 1" }
    assert(Statistics.peopleCount == 2) { "People dinner count should be 2" }
    assert(Statistics.robotCount == 1) { "Robot dinner count should be 1" }

    println("All tests passed!")
}
