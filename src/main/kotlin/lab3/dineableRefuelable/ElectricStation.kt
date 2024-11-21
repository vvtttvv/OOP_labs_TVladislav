package lab3

class ElectricStation : Refuelable {
    override fun refuel(carId: String) {
        println("Refueling electric car $carId.")
        Statistics.incrementElectricCarCount()
    }
}