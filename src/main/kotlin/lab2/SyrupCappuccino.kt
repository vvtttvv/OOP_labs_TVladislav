package lab2

class SyrupCappuccino(
    coffeeIntensity: Intensity,
    name: String = "SyrupCappuccino",
    mlOfMilk: Int,
    private val syrup: SyrupType
) : Cappuccino(coffeeIntensity, name, mlOfMilk,){
    override fun printCoffeeDetails() {
        super.printCoffeeDetails()
        println("It also has $syrup syrup")
    }
}
