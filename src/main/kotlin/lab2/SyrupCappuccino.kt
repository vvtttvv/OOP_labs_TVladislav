package lab2

class SyrupCappuccino(
    coffeeIntensity: Intensity,
    name: String = "SyrupCappuccino",
    mlOfMilk: Int,
    val syrup: SyrupType
) : Cappuccino(coffeeIntensity, name, mlOfMilk,)
