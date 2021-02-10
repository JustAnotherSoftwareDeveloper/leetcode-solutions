/**
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 */
class NonDivisibleSubset {

    fun nonDivisibleSubset(k: Int, s: Array<Int>): Int {
        // Write your code here
        val count = IntArray(k)
        var total = 0
        for (i in s.indices) {
            count[s[i] % k]++
        }
        total = minOf(1,count[0])
        for (i in 1..k/2) {
            total += when {
                i!= k-i -> {
                    maxOf(count[i],count[k-i])
                }
                count[i] != 0 -> {
                    1
                }
                else -> {
                    0
                }
            }
        }
        return total
    }
}