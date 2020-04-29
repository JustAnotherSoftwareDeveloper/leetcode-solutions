/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
class UniquePathsTwo {

    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val dp = Array(obstacleGrid.size) {IntArray(obstacleGrid[0].size)}
        if (obstacleGrid[0][0] == 1) {
            dp[0][0] = 0
        }
        else {
            dp[0][0] = 1
        }
        for (i in dp.indices) {
            for(j in dp[0].indices) {
                val canIMoveRight =  j+1 < dp[0].size && obstacleGrid[i][j+1] == 0
                val canIMoveDown = i +1 < dp.size && obstacleGrid[i+1][j] == 0
                if (canIMoveRight) {
                    dp[i][j+1] += dp[i][j]
                }
                if (canIMoveDown) {
                    dp[i+1][j] += dp[i][j]
                }
            }
        }
        return dp[dp.lastIndex][dp[0].lastIndex]
    }
}