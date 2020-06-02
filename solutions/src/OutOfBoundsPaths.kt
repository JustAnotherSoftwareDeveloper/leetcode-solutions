/**
 * https://leetcode.com/problems/out-of-boundary-paths
 */
class OutOfBoundsPaths {
    fun findPaths(m: Int, n: Int, N: Int, x: Int, y: Int): Int {
        val M = 1000000000 + 7
        var dp = Array(m) { IntArray(n) }
        dp[x][y] = 1
        var count = 0
        for (moves in 1..N) {
            val temp = Array(m) { IntArray(n) }
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (i == m - 1) count = (count + dp[i][j]) % M
                    if (j == n - 1) count = (count + dp[i][j]) % M
                    if (i == 0) count = (count + dp[i][j]) % M
                    if (j == 0) count = (count + dp[i][j]) % M
                    temp[i][j] = (((if (i > 0) dp[i - 1][j] else 0) + if (i < m - 1) dp[i + 1][j] else 0) % M +
                            ((if (j > 0) dp[i][j - 1] else 0) + if (j < n - 1) dp[i][j + 1] else 0) % M) % M
                }
            }
            dp = temp
        }
        return count
    }
}