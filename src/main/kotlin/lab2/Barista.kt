package lab2

import lab2.core.Americano
import lab2.core.Cappuccino
import lab2.core.PumpkinSpiceLatte
import lab2.core.SyrupCappuccino

internal class Barista {
    private val coffeeMap = mutableMapOf<String, Any>()

    fun addCoffee(
        coffeeType: String,
        intensity: Intensity,
        mlOfMilk: Int = 0,
        mlOfWater: Int = 0,
        mgOfPumpkinSpice: Int = 0,
        syrup: SyrupType? = null
    ) {
        val coffee = when (coffeeType) {
            "Cappuccino" -> Cappuccino(intensity, mlOfMilk = mlOfMilk)
            "Americano" -> Americano(intensity, mlOfWater = mlOfWater)
            "PumpkinSpiceLatte" -> PumpkinSpiceLatte(intensity, mlOfMilk = mlOfMilk, mgOfPumpkinSpice = mgOfPumpkinSpice)
            "SyrupCappuccino" -> SyrupCappuccino(intensity, mlOfMilk = mlOfMilk, syrup = syrup ?: SyrupType.VANILLA)
            else -> throw IllegalArgumentException("Unknown coffee type")
        }
        coffeeMap[coffeeType] = coffee
    }

    fun makeCoffee(coffeeType: String) {
        val coffee = coffeeMap[coffeeType] ?: run {
            println("Coffee type \"$coffeeType\" not found.")
            return
        }
        when (coffee) {
            is PumpkinSpiceLatte -> coffee.makePumpkinSpiceLatte()
            is SyrupCappuccino -> coffee.makeSyrupCappuccino()
            is Cappuccino -> coffee.makeCappuccino()
            is Americano -> coffee.makeAmericano()
        }
        println("Drink wise!\n")
    }

    fun showInfo() {
        println("You decided to show the information:\n")
        for (coffee in coffeeMap.values) {
            when (coffee) {
                is PumpkinSpiceLatte -> coffee.printPumpkinSpiceLatteDetails()
                is SyrupCappuccino -> coffee.printSyrupCappuccinoDetails()
                is Cappuccino -> coffee.printCappuccinoDetails()
                is Americano -> coffee.printAmericanoDetails()
            }
            println()
        }
    }

}
