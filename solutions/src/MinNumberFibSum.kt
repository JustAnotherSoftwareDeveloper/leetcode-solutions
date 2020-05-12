/**
 * https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 */
class MinNumberFibSum {
    fun findMinFibonacciNumbers(k: Int) : Int {
       if (k < 2) return k
        var a = 1
        var b = 1
        while (b <= k) {
            b += a
            a = b - a
        }
        return 1 + findMinFibonacciNumbers(k - a)
    }
}