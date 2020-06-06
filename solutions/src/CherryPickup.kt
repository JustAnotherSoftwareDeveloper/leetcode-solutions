import java.util.*


/**
 * https://leetcode.com/problems/cherry-pickup/
 */
class CherryPickup {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val n = grid.size
        val dp = Array(n + 1) { Array(n + 1) { IntArray(n + 1) } }
        for (i in 0..n) {
            for (j in 0..n) {
                Arrays.fill(dp[i][j], Int.MIN_VALUE)
            }
        }
        dp[1][1][1] = grid[0][0]
        for (x1 in 1..n) {
            for (y1 in 1..n) {
                for (x2 in 1..n) {
                    val y2 = x1 + y1 - x2
                    if (dp[x1][y1][x2] > 0 || y2 < 1 || y2 > n || grid[x1 - 1][y1 - 1] == -1 || grid[x2 - 1][y2 - 1] == -1) {
                        continue
                        // have already detected || out of boundary || cannot access
                    }
                    val cur = Math.max(Math.max(dp[x1 - 1][y1][x2], dp[x1 - 1][y1][x2 - 1]), Math.max(dp[x1][y1 - 1][x2], dp[x1][y1 - 1][x2 - 1]))
                    if (cur < 0) {
                        continue
                    }
                    dp[x1][y1][x2] = cur + grid[x1 - 1][y1 - 1]
                    if (x1 != x2) {
                        dp[x1][y1][x2] += grid[x2 - 1][y2 - 1]
                    }
                }
            }
        }
        return if (dp[n][n][n] < 0) 0 else dp[n][n][n]
    }

}

