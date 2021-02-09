/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
class ReverseVowels {

    fun reverseVowels(s: String): String {
        val sToModify = s.toCharArray();
        val vowelMap = mutableMapOf<Int, Char>()
        var currentVowel = 0;
        val vowelOccuranceMap = mutableMapOf<Int, Char>()
        s.forEachIndexed { index, c ->
            if (setOf('a', 'e', 'i', 'o', 'u','A','E','I','O','U').contains(c)) {
                vowelMap[index] = c;
                vowelOccuranceMap[currentVowel] = c
                currentVowel++
            }

        }
        vowelMap.keys.sorted().forEach {
            currentVowel--
            sToModify[it] = vowelOccuranceMap[currentVowel]!!
        }

        return if (sToModify.isNotEmpty()) sToModify.map { "$it" }.reduce { acc, s -> "$acc$s" } else "";
    }
}