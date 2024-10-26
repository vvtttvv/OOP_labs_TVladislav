package lab1

fun main(args: Array<String>) {
    // Day 1
    val display1 = Display(1920, 1080, 405f, "Display1")
    val display2 = Display(1200, 500, 400f, "Display2")
    val display3 = Display(1000, 2000, 300f, "Display3")

    println("\nComparing 1 object with 2")
    display1.compareSize(display2)
    println("\nComparing 3 object with 2")
    display3.compareSharpness(display2)
    println("\nComparing 1 object with 3")
    display1.compareWithMonitor(display3)

    // Day 2
    if (args.isEmpty()) {
        println("\nPlease provide the file path as a command-line argument.")
        return
    }

    val filePath = args[0]
    val fileReader = FileReader()
    val text = fileReader.readFileIntoString(filePath)
    val textData = TextData(filePath, text)
    val showInfo = textData.textData() // I could choose not to use this variable, but linter forces me to
    println(showInfo)

    // Day 3
    val assistant = Assistant("HelperBot")
    assistant.assignDisplay(display1, display2, display3)

    println("\nAssistant is comparing displays:")
    assistant.assist()

    println("\nBuying a display:")
    val boughtDisplay = assistant.buyDisplay(display2)
    if (boughtDisplay != null) {
        println("Bought display: $boughtDisplay")
    } else {
        println("Display not found for purchase.")
    }
}
