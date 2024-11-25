package lab3

class ElectricStation : Refuelable {
    override fun refuel(carId: Int, consumption: Int, passengers: String) {
        println("Refueling electric car $carId.")
        Statistics.incrementElectricCarCount()
        Statistics.incrementElectricConsumption(consumption)
        Statistics.incrementPassengers(passengers)
    }
}