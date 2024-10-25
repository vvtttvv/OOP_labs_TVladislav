package lab1

fun main() {
    val display1 = Display(1920, 1080, 405f, "Display1")
    val display2 = Display(1200, 500, 400f, "Display2")
    val display3 = Display(1000, 2000, 300f, "Display3")

    println("\nComparing 1 object with 2")
    display1.compareSize(display2)
    display1.compareSharpness(display2)
    display1.compareWithMonitor(display2)

    println("\nComparing 3 object with 2")
    display3.compareSize(display2)
    display3.compareSharpness(display2)
    display3.compareWithMonitor(display2)

    println("\nComparing 1 object with 3")
    display1.compareSize(display3)
    display1.compareSharpness(display3)
    display1.compareWithMonitor(display3)
}