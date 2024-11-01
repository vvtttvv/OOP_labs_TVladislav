package lab2

import java.util.Scanner

internal fun displayCoffeeMenu(barista: Barista) {
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Hello! I'm Robo Steve! And I'm here to make robo-coffee - coffee for robots!\n")
        println("Select an option:")
        println("1 - Add coffee")
        println("2 - Show info")
        println("3 - Make coffee")
        println("4 - Exit")

        when (scanner.nextInt()) {
            2 -> {
                barista.showInfo()
                println("Press 3 to make one of the coffees above!\n")
            }
            1 -> {
                println("You will never forget our robo-coffee! Trust Robo Steve!\n")
                println("Enter coffee type (Cappuccino, Americano, PumpkinSpiceLatte, SyrupCappuccino):")
                val coffeeType = scanner.next()
                //Here could be error handling  but I'm too tired

                println("Enter intensity (LIGHT, NORMAL, STRONG):")
                val intensity = Intensity.valueOf(scanner.next().uppercase())

                println("Enter ml of milk (0 if none):")
                val mlOfMilk = scanner.nextInt()

                println("Enter ml of water (0 if none):")
                val mlOfWater = scanner.nextInt()

                println("Enter mg of pumpkin spice (0 if none):")
                val mgOfPumpkinSpice = scanner.nextInt()

                println("Enter syrup type (CARAMEL, VANILLA, HAZELNUT, or NONE if no syrup):")
                val syrupInput = scanner.next().uppercase()
                val syrup = if (syrupInput == "NONE") null else SyrupType.valueOf(syrupInput)

                barista.addCoffee(coffeeType, intensity, mlOfMilk, mlOfWater, mgOfPumpkinSpice, syrup)
            }
            3 -> {
                println("Enter coffee type to make:")
                val coffeeType = scanner.next()
                barista.makeCoffee(coffeeType)
            }
            4 -> {
                println("Exiting...")
                break
            }
            else -> println("Invalid option. Please try again.")
        }
    }
}
