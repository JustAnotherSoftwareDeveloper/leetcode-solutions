/**
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */
class CountCharacters {

    fun countCharacters(words: Array<String>, chars: String): Int {
        val charsByFreq = chars.groupingBy { it }.eachCount()

        return words
                .filter {
            val charsByFreqLocal = charsByFreq.toMutableMap()
                    var valid = true
            for (c in it) {
                val freq = charsByFreqLocal.getOrDefault(c, 0);
                if (0 >= freq) {
                    valid = false
                } else {
                    charsByFreqLocal[c] = charsByFreqLocal[c]!! - 1
                }

            }
            valid
        }
                .map { it.length }
                .sum()
    }
}