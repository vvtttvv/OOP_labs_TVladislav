package lab2

open class Cappuccino(
    coffeeIntensity: Intensity,
    name: String = "Cappuccino",
    val mlOfMilk: Int
) : Coffee(coffeeIntensity, name){
    fun makeCappuccino(){
        super.printCoffeeDetails()
        println("Adding $mlOfMilk ml of milk")
        println("Ding, dang! Cappuccino is done!")
    }
}