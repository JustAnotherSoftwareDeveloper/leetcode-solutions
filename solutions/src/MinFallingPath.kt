/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 */
class MinFallingPath {
    fun minFallingPathSum(A: Array<IntArray>) : Int {
        val dp = Array(A.size) {IntArray(A[0].size)}
        for(i in A[0].indices) {
            dp[0][i] = A[0][i]
        }
        for(i in 1 until dp.size) {
            for (j in dp[0].indices) {
                val prevRowValues = mutableListOf(dp[i-1][j])
                if (j < dp[0].lastIndex) {
                    prevRowValues.add(dp[i-1][j+1])
                }
                if (j > 0) {
                    prevRowValues.add(dp[i-1][j-1])
                }
                dp[i][j] = A[i][j]+prevRowValues.min()!!
            }
        }


        return dp[dp.lastIndex].min()!!
    }
}