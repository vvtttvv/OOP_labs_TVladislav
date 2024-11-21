package lab3

fun testCarStation() {
    val mockDiningService = object : Dineable {
        override fun serveDinner(carId: String) {
            println("Mock: Serving dinner to car $carId")
        }
    }

    val mockRefuelingService = object : Refuelable {
        override fun refuel(carId: String) {
            println("Mock: Refueling car $carId")
        }
    }

    val queue = CircularQueue<Car>(10)
    val carStation = CarStation(mockDiningService, mockRefuelingService, queue)

    println("Test 1: Empty queue")
    carStation.serveCars()

    println("Test 2: Car without dining")
    carStation.addCar(Car("1", "ELECTRIC", "PEOPLE", false))
    carStation.serveCars()

    println("Test 3: Car with dining")
    carStation.addCar(Car("2", "GAS", "ROBOTS", true))
    carStation.serveCars()
}
