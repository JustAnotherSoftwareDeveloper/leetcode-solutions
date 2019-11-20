class PathWithMaxGold {

    fun getMaximumGold(grid: Array<IntArray>) : Int {
        var maxGold = 0
        for(i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] != 0) {
                    val maxAtPoint = maxGoldDFS(Pair(i,j),grid, mutableSetOf())
                    println("$i,$j: $maxAtPoint")
                    maxGold = maxOf(maxGold,maxAtPoint)
                }
            }
        }
        return maxGold
    }

    fun maxGoldDFS(coordinates: Pair<Int,Int>, grid: Array<IntArray>, visited: MutableSet<Pair<Int,Int>>) : Int {
        if (coordinates.first > grid.lastIndex || coordinates.first < 0) {
            return 0
        }
        if (coordinates.second > grid[0].lastIndex || coordinates.second < 0) {
            return 0
        }
        if (visited.contains(coordinates)) {
            return 0
        }
        if (grid[coordinates.first][coordinates.second] ==  0) {
            return 0
        }
        visited.add(coordinates)
        val maxFromPath = mutableListOf<Int>()

            maxFromPath.add(maxGoldDFS(Pair(coordinates.first+1,coordinates.second),grid,visited.toMutableSet()))
            maxFromPath.add(maxGoldDFS(Pair(coordinates.first-1,coordinates.second),grid,visited.toMutableSet()))
            maxFromPath.add(maxGoldDFS(Pair(coordinates.first,coordinates.second+1),grid,visited.toMutableSet()))
            maxFromPath.add(maxGoldDFS(Pair(coordinates.first,coordinates.second-1),grid, visited.toMutableSet()))

        return grid[coordinates.first][coordinates.second] + (maxFromPath.max() ?: 0)
    }
}