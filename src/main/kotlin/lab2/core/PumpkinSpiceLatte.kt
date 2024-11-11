package lab2.core

import lab2.Intensity

internal class PumpkinSpiceLatte(
    coffeeIntensity: Intensity,
    name: String = "PumpkinSpiceLatte",
    mlOfMilk: Int,
    private val mgOfPumpkinSpice: Int
) : Cappuccino(coffeeIntensity, name, mlOfMilk){

    fun makePumpkinSpiceLatte() {
        super.makeCoffee()
        println("Adding " + this.mlOfMilk + " ml of milk")
        println("Adding $mgOfPumpkinSpice mg of spice")
        println("Ding, dang! Pumpkin Spice Latte is done!\n")
    }

    fun printPumpkinSpiceLatteDetails(){
        super.printCappuccinoDetails()
        println("Amount of Pumpkin Spice: $mgOfPumpkinSpice ml")
    }
}

// !!! Not forget to ask Mr. Domenic about the best way of solving conflicts, with override or putting in arguments as I did
