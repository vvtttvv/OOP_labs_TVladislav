package lab1

class TextData(private val fileName: String, private val text: String) {
    private val vowels = "AEIOUaeiou"
    private val consonants = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz"

    private val numberOfVowels: Int = text.count { it in vowels }
    private val numberOfConsonants: Int = text.count { it in consonants }
    private val numberOfLetters: Int = text.count { it.isLetter() }
    private val numberOfSentences: Int = text.split(Regex("[.!?]")).size - 1
    private val longestWord: String = text.split(Regex("\\W+")).maxByOrNull { it.length } ?: "Here could be a word :("

    private fun getFilename() = fileName
    private fun getText() = text
    private fun getNumberOfVowels() = numberOfVowels
    private fun getNumberOfConsonants() = numberOfConsonants
    private fun getNumberOfLetters() = numberOfLetters
    private fun getNumberOfSentences() = numberOfSentences
    private fun getLongestWord() = longestWord

    fun textData(): String {
        return """
            File Name: ${getFilename()}
            File Text: ${getText()}
            Number of Vowels: ${getNumberOfVowels()}
            Number of Consonants: ${getNumberOfConsonants()}
            Number of Letters: ${getNumberOfLetters()}
            Number of Sentences: ${getNumberOfSentences()}
            Longest Word: ${getLongestWord()}
        """.trimIndent() //To delete spaces
    }
}
