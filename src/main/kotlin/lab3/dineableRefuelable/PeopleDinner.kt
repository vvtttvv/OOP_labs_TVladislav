package lab3

class PeopleDinner : Dineable {
    override fun serveDinner(carId: String) {
        println("Serving dinner to people in car $carId.")
        Statistics.incrementPeopleCount()
    }
}