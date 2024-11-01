package lab2

class SyrupCappuccino(
    coffeeIntensity: Intensity,
    name: String = "SyrupCappuccino",
    mlOfMilk: Int,
    private val syrup: SyrupType
) : Cappuccino(coffeeIntensity, name, mlOfMilk,){
    fun makeSyrupCappuccino() {
        super.printCoffeeDetails()
        println("Adding $syrup syrup")
        println("Ding, dang! Syrup Cappuccino is done!")
    }
}
