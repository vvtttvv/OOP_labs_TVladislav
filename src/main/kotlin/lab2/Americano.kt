package lab2

class Americano(
    coffeeIntensity: Intensity,
    private val mlOfWater: Int
) : Coffee(coffeeIntensity, name = "Americano"){
    override fun printCoffeeDetails() {
        super.printCoffeeDetails()
        println("It has: $mlOfWater ml of water")
    }
}
