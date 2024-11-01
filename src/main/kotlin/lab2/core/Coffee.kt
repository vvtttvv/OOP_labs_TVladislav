package lab2.core

import lab2.Intensity

//Ask about import kotlin.reflect.full.memberProperties to use them in function like for ... in

internal open class Coffee(
    private val  coffeeIntensity: Intensity,
    val name: String = "Coffee"
){
    fun makeCoffee(){
        println("Let's make " + (this.name) + "!")
        println("Intensity set to " + this.coffeeIntensity.toString())
    }

    fun printCoffeeDetails(){
        println("Coffee: " + (this.name))
        println("Intensity:  " + this.coffeeIntensity.toString())
    }


}
