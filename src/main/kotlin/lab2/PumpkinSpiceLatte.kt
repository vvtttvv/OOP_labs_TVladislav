package lab2

class PumpkinSpiceLatte(
    coffeeIntensity: Intensity,
    name: String = "PumpkinSpiceLatte",
    mlOfMilk: Int,
    private val mgOfPumpkinSpice: Int
) : Cappuccino(coffeeIntensity, name, mlOfMilk){
    override fun printCoffeeDetails() {
        super.printCoffeeDetails()
        println("It has $mgOfPumpkinSpice mg")
    }
}

// !!! Not forget to ask Mr. Domenic about the best way of solving conflicts, with override or with arguments as I did
