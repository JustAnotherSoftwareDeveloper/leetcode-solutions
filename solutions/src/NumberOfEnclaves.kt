/**
 * https://leetcode.com/problems/number-of-enclaves/
 */
class NumberOfEnclaves {


    fun numEnclaves(grid: Array<IntArray>): Int {
        var numEnclaves = 0

        val visited = mutableSetOf<Pair<Int,Int>>()
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                val enclave = dfsEnclave(Pair(i,j),visited,grid)
                if (enclave != -1) {
                    numEnclaves+=enclave
                }
            }
        }
        return numEnclaves
    }


    private fun dfsEnclave(space: Pair<Int,Int>, visited: MutableSet<Pair<Int,Int>>, grid: Array<IntArray>) : Int {
        if (visited.contains(space)) {
            return 0
        }
        if (space.first !in grid.indices || space.second !in grid[0].indices) {
            return -1
        }
        if (grid[space.first][space.second] == 0) {
            return 0
        }
        visited.add(space)

        val moves = listOf(
                dfsEnclave(Pair(space.first+1,space.second),visited,grid),
                dfsEnclave(Pair(space.first-1,space.second),visited,grid),
                dfsEnclave(Pair(space.first,space.second+1),visited,grid),
                dfsEnclave(Pair(space.first,space.second-1),visited,grid)
        )

        return if (moves.any { it == -1 }) {
            -1
        }
        else {
            1+moves.sum()
        }
    }
}