package lab3

class CarStation(
    private val diningService: Dineable,
    private val refuelingService: Refuelable,
    private val queue: Queue<Car>
) {
    fun addCar(car: Car) {
        queue.enqueue(car)
    }

    fun serveCars() {
        while (!queue.isEmpty()) {
            val car = queue.dequeue()
            if (car!!.isDining) {
                diningService.serveDinner(car.id)
            }
            refuelingService.refuel(car.id, car.consumption, car.passengers)
        }
    }
}
