package lab3

class Semaphore(
    private val gasStation: CarStation,
    private val electricStation: CarStation
) {

    fun routeCar(car: Car) {
        when (car.type) {
            "GAS" -> {
                gasStation.addCar(car)
            }
            "ELECTRIC" -> {
                electricStation.addCar(car)
            }
            else -> {
                println("Unknown car type: ${car.type}")
            }
        }

    }
}
