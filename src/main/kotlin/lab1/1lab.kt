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

    // Day 2 & 4
    if (args.isEmpty()) {
        println("\nPlease provide the file path as a command-line argument.")
        return
    }

    for (filePath in args) {
        println("\nProcessing file: $filePath")
        val fileReader = FileReader()
        val text = fileReader.readFileIntoString(filePath)
        val textData = TextData(filePath, text)
        println(textData.textData())
    }

    // Day 3
    val assistant = Assistant("SadHelper")

    assistant.assignDisplay(display1, display2, display3)


    while (true) {
        println("\nMenu:")
        println("1. Compare Displays")
        println("2. Buy Display")
        println("3. Exit")

        print("Enter your choice: ")
        val choice = readlnOrNull()

        when (choice) {
            "1" -> {
                println("\nComparing Displays:")
                assistant.assist()
            }

            "2" -> {
                println("\nBuying a display:")
                println("Choose a display to buy (0 to ${assistant.assignedDisplays.size - 1}):")
                val selectedDisplay = readlnOrNull()?.toIntOrNull()
                if (selectedDisplay != null && selectedDisplay in 0 until assistant.assignedDisplays.size) {
                    val boughtDisplay = assistant.buyDisplay(assistant.assignedDisplays[selectedDisplay])
                    if (boughtDisplay != null) {
                        println("Bought display: $boughtDisplay")
                    } else {
                        println("Display not found for purchase.")
                    }
                } else {
                    println("Invalid display selection.")
                }
            }

            else -> {
                println("Exiting the session.")
                return
            }
        }
    }
}
