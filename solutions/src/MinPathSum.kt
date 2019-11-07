//https://leetcode.com/problems/minimum-path-sum/
class MinPathSum {

    fun minPathSum(grid: Array<IntArray>) : Int {

        val dp = mutableListOf<MutableList<Int>>()
        for (i in grid.indices) {
            dp.add(mutableListOf())
            for (j in grid[0]!!.indices) {
                dp[i].add(0)
            }
        }

        for (i in dp.lastIndex downTo 0) {
            for(j in dp[0].lastIndex downTo 0) {
                val rightMax = if(j >= dp[0].lastIndex) Int.MAX_VALUE else dp[i][j+1]
                val downMax = if (i >= dp.lastIndex ) Int.MAX_VALUE else dp[i+1][j]
                val completeMin = if (rightMax == Int.MAX_VALUE && downMax == Int.MAX_VALUE) 0 else minOf(rightMax,downMax)
                val shortest = grid[i][j]+completeMin
                dp[i][j] = shortest
            }
        }

        return dp[0][0]
    }
}