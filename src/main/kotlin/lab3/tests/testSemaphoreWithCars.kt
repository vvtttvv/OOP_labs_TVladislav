package lab3

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

fun testSemaphoreWithCars() {
    Statistics.resetStats()

    val gasDiningService = PeopleDinner()
    val electricDiningService = RobotDinner()
    val gasRefuelingService = GasStation()
    val electricRefuelingService = ElectricStation()

    val gasQueue = CircularQueue<Car>(10)
    val electricQueue = CircularQueue<Car>(10)

    val gasStation = CarStation(gasDiningService, gasRefuelingService, gasQueue)
    val electricStation = CarStation(electricDiningService, electricRefuelingService, electricQueue)

    val semaphore = Semaphore(gasStation, electricStation)

    val carInputs = listOf(
        """{"id": 1, "type": "GAS", "passengers": "PEOPLE", "isDining": true, "consumption": 16}""",
        """{"id": 2, "type": "ELECTRIC", "passengers": "ROBOTS", "isDining": true, "consumption": 12}""",
        """{"id": 3, "type": "GAS", "passengers": "PEOPLE", "isDining": true , "consumption": 20}""",
        """{"id": 4, "type": "ELECTRIC", "passengers": "ROBOTS", "isDining": true, "consumption": 10}""",
        """{"id": 5, "type": "UNKNOWN", "passengers": "PEOPLE", "isDining": false, "consumption": 15}"""
    )

    for (carJson in carInputs) {
        val car = parseCarFromJson(carJson)
        semaphore.routeCar(car)
    }

    gasStation.serveCars()
    electricStation.serveCars()

    assert(Statistics.gasCars == 2) { "Expected 2 gas cars served, but found ${Statistics.gasCars}" }
    assert(Statistics.electricCars == 2) { "Expected 2 electric cars served, but found ${Statistics.electricCars}" }
    assert(Statistics.peopleCount == 2) { "Expected 3 people served, but found ${Statistics.peopleCount}" }
    assert(Statistics.robotCount == 2) { "Expected 2 robots served, but found ${Statistics.robotCount}" }

    println("All Semaphore tests passed successfully.")
}

fun parseCarFromJson(carJson: String): Car {
    val objectMapper = jacksonObjectMapper()
    return objectMapper.readValue(carJson)
}
