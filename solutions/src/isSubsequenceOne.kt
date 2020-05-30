/**
 * https://leetcode.com/problems/is-subsequence/
 */
class isSubsequenceOne {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.length > t.length) {
            return false
        }
        var currSize = 0
        var currSIndex = 0
        t.forEach {
            if (currSize == s.length) {
                return true
            }
            if (it == s[currSIndex]) {
                currSize++
                currSIndex++
            }

        }
        return currSize == s.length
    }
}