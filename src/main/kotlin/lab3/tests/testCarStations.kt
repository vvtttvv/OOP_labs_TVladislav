package lab3

fun testCarStation() {
    Statistics.resetStats()

    val diningService = PeopleDinner()
    val refuelingService = GasStation()

    val carQueue = CircularQueue<Car>(10)

    val carStation = CarStation(diningService, refuelingService, carQueue)

    val car1 = Car(id = 1, type = "Sedan", passengers = "John, Alice", consumption = 8, isDining = true)
    val car2 = Car(id = 2, type = "SUV", passengers = "Bob", consumption = 12, isDining = false)
    val car3 = Car(id = 3, type = "Hatchback", passengers = "Charlie", consumption = 6, isDining = true)

    carStation.addCar(car1)
    carStation.addCar(car2)
    carStation.addCar(car3)

    assert(carQueue.size() == 3) { "Expected 3 cars in the queue, but found ${carQueue.size()}" }

    carStation.serveCars()

    assert(carQueue.isEmpty()) { "Queue should be empty after serving all cars" }

    assert(Statistics.peopleCount == 2) { "Expected 2 dinners served to people, but found ${Statistics.peopleCount}" }
    assert(Statistics.gasCars == 3) { "Expected 3 gas cars refueled, but found ${Statistics.gasCars}" }
}
