package lab3

class GasStation : Refuelable {
    override fun refuel(carId: String) {
        println("Refueling gas car $carId.")
        Statistics.incrementGasCarCount()
    }
}