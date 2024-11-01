package lab2

fun main() {
    val cappuccino = Cappuccino(coffeeIntensity = Intensity.LIGHT, mlOfMilk = 45)
    cappuccino.makeCappuccino()
    val pumpkinSpiceLatte = PumpkinSpiceLatte(coffeeIntensity = Intensity.NORMAL, mlOfMilk = 45, mgOfPumpkinSpice=45)
    pumpkinSpiceLatte.makePumpkinSpiceLatte()
    val syrupCappuccino = SyrupCappuccino(coffeeIntensity = Intensity.NORMAL, mlOfMilk = 45, syrup = SyrupType.CARAMEL)
    syrupCappuccino.makeSyrupCappuccino()
    val americano = Americano(coffeeIntensity = Intensity.STRONG, mlOfWater = 55)
    americano.makeAmericano()
}
