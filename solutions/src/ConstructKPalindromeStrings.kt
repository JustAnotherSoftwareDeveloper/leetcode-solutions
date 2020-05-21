/**
 * https://leetcode.com/problems/construct-k-palindrome-strings/
 * Taken from solutions. Not good with bitwise
 */
class ConstructKPalindromeStrings {


    fun canConstruct(s: String, k: Int): Boolean {
        var odd = 0
        val n = s.length
        val count = IntArray(26)
        for (i in 0 until n) {
            count[s[i] - 'a'] = count[s[i] - 'a'] xor 1
            odd += if (count[s[i] - 'a'] > 0) 1 else -1
        }
        return k in odd..n
    }
}