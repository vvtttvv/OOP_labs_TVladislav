package lab2.core

import lab2.Intensity

internal class Americano(
    coffeeIntensity: Intensity,
    private val mlOfWater: Int
) : Coffee(coffeeIntensity, name = "Americano"){

    fun makeAmericano() {
        super.makeCoffee()
        println("Adding $mlOfWater ml of water")
        println("Ding, dang! Americano is done!\n")
    }

    fun printAmericanoDetails(){
        super.printCoffeeDetails()
        println("Amount of water: $mlOfWater ml")
    }
}
