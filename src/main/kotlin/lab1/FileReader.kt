package lab1

import java.io.File

class FileReader {
    fun readFileIntoString(path: String): String {
        return File(("src/main/resources/$path")).readText()
    }
}