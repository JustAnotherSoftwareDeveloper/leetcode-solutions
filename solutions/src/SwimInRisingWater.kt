import kotlin.coroutines.coroutineContext
import kotlin.math.min

/**
 * https://leetcode.com/problems/swim-in-rising-water/
 */
class SwimInRisingWater {
    fun swimInWater(grid: Array<IntArray>) : Int {
        var low = grid[0][0]
        var high = grid.size*grid.size -1
        while (low <= high) {
            val guessTime = (low + (high-low)/2)
            val canReachEnd = hasPath(guessTime, Pair(0,0),grid, mutableSetOf())
            if (canReachEnd) {
                high = guessTime-1
            }
            else {
                low= guessTime+1
            }
        }
        return low
    }
    private fun hasPath(currTime: Int, coordinates: Pair<Int,Int>, grid: Array<IntArray>, visited: MutableSet<Pair<Int,Int>>) : Boolean {
        if (coordinates.first < 0 ||
                coordinates.first >= grid.size ||
                coordinates.second < 0 ||
                coordinates.second >= grid.size ||
                visited.contains(coordinates) ||
                        grid[coordinates.first][coordinates.second] > currTime
        ) {
            return false
        }
        if (coordinates.first == grid.lastIndex && coordinates.second == grid.lastIndex) {
            return true
        }
        visited.add(coordinates)
        return listOf(
                Pair(coordinates.first+1,coordinates.second),
                Pair(coordinates.first-1,coordinates.second),
                Pair(coordinates.first, coordinates.second+1),
                Pair(coordinates.first,coordinates.second-1)
        ).any { hasPath(currTime,it,grid,visited) }
    }
}