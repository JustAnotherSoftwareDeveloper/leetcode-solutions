//https://leetcode.com/problems/max-increase-to-keep-city-skyline/submissions/
class CitySkyline {

    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>) : Int {
        val maxRows = arrayOfNulls<Int>(grid.size)
        val maxColumns = arrayOfNulls<Int>(grid[0].size)
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                maxRows[i] = maxOf(grid[i][j],maxRows[i] ?: 0)
                maxColumns[j] = maxOf(grid[i][j],maxColumns[j] ?: 0)
            }
        }
        var totalIncrease = 0
        for(i in grid.indices) {
            for (j in grid.indices) {
                totalIncrease+= minOf(maxRows[i]?:0,maxColumns[j]?:0) - grid[i][j]
            }
        }
        return totalIncrease
    }
}