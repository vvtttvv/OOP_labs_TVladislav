package lab3

class PeopleDinner : Dineable {
    override fun serveDinner(carId: Int) {
        println("Serving dinner to people in car $carId.")
        Statistics.incrementPeopleCount()
    }
}