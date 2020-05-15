/**
 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
 */
class ValidPathOnGrid {

    fun hasValidPath(grid: Array<IntArray>) : Boolean {
        val queue = mutableListOf(Pair(0,0))
        val visited = mutableSetOf<Pair<Int,Int>>()
        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0)
            visited.add(current)
            if (current.first == grid.lastIndex && current.second == grid[0].lastIndex) {
                return true
            }
            val possibleSteps = mutableListOf<Pair<Int,Int>>()
            when (grid[current.first][current.second]) {
                1 -> {
                    possibleSteps.add(Pair(current.first,current.second+1))
                    possibleSteps.add(Pair(current.first,current.second-1))
                }
                2 -> {
                    possibleSteps.add(Pair(current.first+1,current.second))
                    possibleSteps.add(Pair(current.first-1,current.second))
                }
                3 -> {
                    possibleSteps.add(Pair(current.first,current.second-1))
                    possibleSteps.add(Pair(current.first+1,current.second))
                }
                4 -> {
                    possibleSteps.add(Pair(current.first,current.second+1))
                    possibleSteps.add(Pair(current.first+1,current.second))

                }
                5 -> {
                    possibleSteps.add(Pair(current.first-1,current.second))
                    possibleSteps.add(Pair(current.first,current.second-1))
                }
                else -> {
                    possibleSteps.add(Pair(current.first-1,current.second))
                    possibleSteps.add(Pair(current.first,current.second+1))
                }
            }
            queue.addAll(possibleSteps.filter { !visited.contains(it) && acceptsDirection(current,it,grid) })
        }

        return false

    }

    private fun acceptsDirection(source: Pair<Int,Int>,target: Pair<Int,Int>, grid: Array<IntArray>) : Boolean {
        if (target.first < 0 || target.first > grid.lastIndex || target.second < 0 || target.second > grid[0].lastIndex) {
            return false
        }
        val streetType = grid[target.first][target.second]
        if (source.second > target.second) {
            return setOf(1,4,6).contains(streetType)
        }
        if (source.second < target.second) {
            return setOf(1,3,5).contains(streetType)
        }
        if (source.first > target.first) {
            return setOf(2,3,4).contains(streetType)
        }
        if (source.first < target.first) {
            return setOf(2,5,6).contains(streetType)
        }
        return false
    }
}