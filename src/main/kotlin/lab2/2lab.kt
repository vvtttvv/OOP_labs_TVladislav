package lab2

fun main() {
    val cappuccino = Cappuccino(coffeeIntensity = Intensity.LIGHT, mlOfMilk = 45)
    println("Created drink: ${cappuccino.name}, Intensity: ${cappuccino.coffeeIntensity}, mlOfMilk: ${cappuccino.mlOfMilk}")
}
