/**
 * https://leetcode.com/problems/ones-and-zeroes/
 */
class OnesAndZeros {

    fun findMaxForm(strs: Array<String>, m: Int, n: Int) : Int {
        val dp = Array(m+1) {IntArray(n+1)}
        strs.forEach { s ->
            val numZeros = s.filter { it == '0' }.length
            val numOnes = s.filter { it == '1' }.length
            for(i in m downTo numZeros) {
                for (j in n downTo numOnes) {
                    dp[i][j] = maxOf(1+dp[i-numZeros][j-numOnes],dp[i][j])
                }
            }
        }
        return dp[m][n]
    }
}