package lab2

open class Cappuccino(
    coffeeIntensity: Intensity,
    name: String = "Cappuccino",
    val mlOfMilk: Int
) : Coffee(coffeeIntensity, name)