package lab2

fun main() {
    val cappuccino = Cappuccino(coffeeIntensity = Intensity.LIGHT, mlOfMilk = 45)
    cappuccino.printCoffeeDetails()
    val pumpkinSpiceLatte = PumpkinSpiceLatte(coffeeIntensity = Intensity.NORMAL, mlOfMilk = 45, mgOfPumpkinSpice=45)
    pumpkinSpiceLatte.printCoffeeDetails()
    val syrupCappuccino = SyrupCappuccino(coffeeIntensity = Intensity.NORMAL, mlOfMilk = 45, syrup = SyrupType.CARAMEL)
    syrupCappuccino.printCoffeeDetails()
}
