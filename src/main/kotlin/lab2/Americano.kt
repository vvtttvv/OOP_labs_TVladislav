package lab2

class Americano(
    coffeeIntensity: Intensity,
    val mlOfWater: Int
) : Coffee(coffeeIntensity, name = "Americano")
