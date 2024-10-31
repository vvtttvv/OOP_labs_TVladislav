package lab2

class PumpkinSpiceLatte(
    coffeeIntensity: Intensity,
    name: String = "PumpkinSpiceLatte",
    mlOfMilk: Int,
    val mgOfPumpkinSpice: Int
) : Cappuccino(coffeeIntensity, name, mlOfMilk)
