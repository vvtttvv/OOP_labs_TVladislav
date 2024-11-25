package lab3

class GasStation : Refuelable {
    override fun refuel(carId: Int, consumption: Int, passengers: String) {
        println("Refueling gas car $carId.")
        Statistics.incrementGasCarCount()
        Statistics.incrementGasConsumption(consumption)
        Statistics.incrementPassengers(passengers)
    }
}