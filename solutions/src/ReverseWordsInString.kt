
//https://leetcode.com/problems/reverse-words-in-a-string/
class ReverseWordsInString {

    fun reverseWords(s: String) : String {
        if (s.isBlank()) {
            return ""
        }
        val whiteSpace = Regex("\\s+")
        return s.split(whiteSpace).toList().reversed().filter { it.isNotBlank() }.reduce { acc, s -> "$acc $s" }
    }
}