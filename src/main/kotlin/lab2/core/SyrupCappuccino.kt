package lab2.core

import lab2.Intensity
import lab2.SyrupType

internal class SyrupCappuccino(
    coffeeIntensity: Intensity,
    name: String = "SyrupCappuccino",
    mlOfMilk: Int,
    val syrup: SyrupType
) : Cappuccino(coffeeIntensity, name, mlOfMilk){

    fun makeSyrupCappuccino() {
        super.makeCoffee()
        println("Adding " + this.mlOfMilk + "ml of milk")
        println("Adding $syrup syrup")
        println("Ding, dang! Syrup Cappuccino is done!")
    }

    fun printSyrupCappuccinoDetails(){
        super.printCappuccinoDetails()
        println("Syrup Type: " + this.syrup + "\n")
    }


}
