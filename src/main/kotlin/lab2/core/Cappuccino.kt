package lab2.core

import lab2.Intensity

internal open class Cappuccino(
    coffeeIntensity: Intensity,
    name: String = "Cappuccino",
    val mlOfMilk: Int
) : Coffee(coffeeIntensity, name){

    fun makeCappuccino(){
        super.makeCoffee()
        println("Adding " + this.mlOfMilk + "ml of milk")
        println("Ding, dang! Cappuccino is done!\n")
    }

    fun printCappuccinoDetails(){
        super.printCoffeeDetails()
        println("Amount of milk: " + this.mlOfMilk + " ml")
    }
}
