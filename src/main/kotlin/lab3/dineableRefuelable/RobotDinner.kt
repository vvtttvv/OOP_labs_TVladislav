package lab3

class RobotDinner : Dineable {
    override fun serveDinner(carId: Int) {
        println("Serving dinner to robots in car $carId.")
        Statistics.incrementRobotCount()
    }
}