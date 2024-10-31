package lab2

open class Cappuccino(
    coffeeIntensity: Intensity,
    name: String = "Cappuccino",
    val mlOfMilk: Int
) : Coffee(coffeeIntensity, name){
    override fun printCoffeeDetails(){
        super.printCoffeeDetails()
        println("It has: $mlOfMilk ml")
    }
}