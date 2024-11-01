package lab2

class Americano(
    coffeeIntensity: Intensity,
    private val mlOfWater: Int
) : Coffee(coffeeIntensity, name = "Americano"){
    fun makeAmericano() {
        super.printCoffeeDetails()
        println("Adding $mlOfWater ml of water")
        println("Ding, dang! Americano is done!")
    }
}
