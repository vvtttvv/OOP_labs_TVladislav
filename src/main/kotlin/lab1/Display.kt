package lab1

class Display(
    private val width: Int,
    private val height: Int,
    private val ppi: Float,
    private val model: String
) {
    fun compareSize(m: Display) {
        val thisArea = this.width * this.height
        val otherArea = m.width * m.height

        if (thisArea > otherArea) {
            println("${this.model} has a larger screen size (${thisArea} pixels) than ${m.model} (${otherArea} pixels).")
        } else if (thisArea < otherArea) {
            println("${m.model} has a larger screen size (${otherArea} pixels) than ${this.model} (${thisArea} pixels).")
        } else {
            println("${this.model} and ${m.model} have the same screen size (${thisArea} pixels).")
        }
    }

    fun compareSharpness(m: Display) {
        if (this.ppi > m.ppi) {
            println("${this.model} has a higher screen sharpness (${this.ppi} ppi) than ${m.model} (${m.ppi} ppi).")
        } else if (this.ppi < m.ppi) {
            println("${m.model} has a higher screen sharpness (${m.ppi} ppi) than ${this.model} (${this.ppi} ppi).")
        } else {
            println("${this.model} and ${m.model} have the same screen sharpness (${this.ppi} ppi).")
        }
    }

    fun compareWithMonitor(m: Display) {
        println("Comparison between ${this.model} and ${m.model}:")
        compareSize(m)
        compareSharpness(m)
    }
}
