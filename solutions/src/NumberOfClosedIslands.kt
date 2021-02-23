/**
 * https://leetcode.com/problems/number-of-closed-islands/
 */
class NumberOfClosedIslands {

    fun closedIsland(grid: Array<IntArray>): Int {

        var numIslands = 0
        val visited = mutableSetOf<Pair<Int,Int>>()

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                val currentSpace = Pair(i,j)
                if (!visited.contains(currentSpace) && grid[i][j] == 0) {
                    val validIsland = dfsIsland(currentSpace,visited,grid)
                    numIslands+= if (validIsland) 1 else 0
                }
            }
        }
        return numIslands

    }

    fun dfsIsland(space: Pair<Int,Int>, visited: MutableSet<Pair<Int,Int>>, grid: Array<IntArray>) : Boolean {

        if (space.first >= grid.size || space.second >= grid[0].size || space.first < 0 || space.second < 0 ) {
            return false
        }
        if (grid[space.first][space.second] == 1) {
            return true
        }
        if (visited.contains(space)) {
            return true
        }
        var valid = true

        visited.add(space)
        val possibleMoves = listOf(
                Pair(space.first-1,space.second),
                Pair(space.first+1,space.second),
                Pair(space.first,space.second+1),
                Pair(space.first,space.second-1)
        )
        for (move in possibleMoves) {
            valid = dfsIsland(move,visited,grid) && valid
        }
        return valid
    }
}