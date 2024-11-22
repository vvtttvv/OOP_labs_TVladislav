package lab3

class GasStation : Refuelable {
    override fun refuel(carId: Int) {
        println("Refueling gas car $carId.")
        Statistics.incrementGasCarCount()
    }
}