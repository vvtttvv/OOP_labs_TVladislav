package lab3

class ElectricStation : Refuelable {
    override fun refuel(carId: Int) {
        println("Refueling electric car $carId.")
        Statistics.incrementElectricCarCount()
    }
}