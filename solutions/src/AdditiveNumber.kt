/**
 * https://leetcode.com/problems/additive-number/
 */
class AdditiveNumber {
    fun isAdditiveNumber(num: String): Boolean {
        val n = num.length
        for (i in 1..n / 2) {
            var j = 1
            while (maxOf(j, i) <= n - i - j) {
                if (isValid(i, j, num)) return true
                ++j
            }
        }
        return false
    }

    private fun isValid(i: Int, j: Int, num: String): Boolean {
        if (num[0] == '0' && i > 1) return false
        if (num[i] == '0' && j > 1) return false
        var sum: String
        var x1 = num.substring(0, i).toLong()
        var x2 = num.substring(i, i + j).toLong()
        var start = i + j
        while (start != num.length) {
            x2 += x1
            x1 = x2 - x1
            sum = x2.toString()
            if (!num.startsWith(sum, start)) return false
            start += sum.length
        }
        return true
    }
}