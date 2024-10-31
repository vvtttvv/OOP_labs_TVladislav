package lab2

//Ask about import kotlin.reflect.full.memberProperties

open class Coffee(
    private val  coffeeIntensity: Intensity,
    val name: String = "Coffee"
){
    open fun printCoffeeDetails(){
        println("It's: " + this.name)
        println("It's intensity: " + this.coffeeIntensity.toString())
    }
}