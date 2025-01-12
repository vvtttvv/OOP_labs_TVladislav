package lab1

class Assistant(private val assistantName: String) {
    val assignedDisplays = mutableListOf<Display>()

    fun assignDisplay(vararg displays: Display) {
        assignedDisplays.addAll(displays)
    }

    fun assist() {
        if (assignedDisplays.isEmpty()) {
            println("\n $assistantName has no displays assigned to assist with.")
            return
        }

        println("\nHello, I'm $assistantName and i will help you... Probably...")
        println("Starting assistance for ${assignedDisplays.size} displays.")
        for (i in 0 until assignedDisplays.size - 1) {
            val currentDisplay = assignedDisplays[i]
            val nextDisplay = assignedDisplays[i + 1]
            currentDisplay.compareWithMonitor(nextDisplay)
        }
    }

    fun buyDisplay(displayToBuy: Display): Display? {
        val isRemoved = assignedDisplays.remove(displayToBuy)
        return if (isRemoved) displayToBuy else null
    }
}
