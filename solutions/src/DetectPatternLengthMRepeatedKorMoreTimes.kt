/**
 * https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
 */
class DetectPatternLengthMRepeatedKorMoreTimes {

    fun containsPattern(arr: IntArray, m: Int, k: Int): Boolean {
        var i = 0
        var j = i + m
        var count = 0
        while (j < arr.size) {
            if (arr[i] != arr[j]) {
                count = 0
            } else if (++count == (k - 1) * m) {
                return true
            }
            ++i
            ++j
        }
        return false
    }
}