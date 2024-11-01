package lab2

class PumpkinSpiceLatte(
    coffeeIntensity: Intensity,
    name: String = "PumpkinSpiceLatte",
    mlOfMilk: Int,
    private val mgOfPumpkinSpice: Int
) : Cappuccino(coffeeIntensity, name, mlOfMilk){
    fun makePumpkinSpiceLatte() {
        super.printCoffeeDetails()
        println("Adding $mgOfPumpkinSpice mg of spice")
        println("Ding, dang! Pumpkin Spice Latte is done!")
    }
}

// !!! Not forget to ask Mr. Domenic about the best way of solving conflicts, with override or putting in arguments as I did
