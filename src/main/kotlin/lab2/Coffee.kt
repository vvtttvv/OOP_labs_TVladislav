package lab2

//Ask about import kotlin.reflect.full.memberProperties to use them in function like for ... in

open class Coffee(
    private val  coffeeIntensity: Intensity,
    val name: String = "Coffee"
){
    open fun printCoffeeDetails(){
        println("Let's make " + (this.name) + "!")
        println("Intensity set to " + this.coffeeIntensity.toString())
    }
}