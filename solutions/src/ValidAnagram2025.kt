class ValidAnagram2025 {

    fun isAnagram(s: String, t: String): Boolean {
        fun buildMap(word: String): Map<Char,Int> {
            val wordMap = mutableMapOf<Char,Int>()
            word.forEach {
                wordMap[it] = 1 + (wordMap[it]?:0)
            }
            return wordMap
        }
        return buildMap(s) == buildMap(t)
    }
}