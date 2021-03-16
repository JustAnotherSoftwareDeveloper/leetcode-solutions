/**
 * https://leetcode.com/problems/count-servers-that-communicate/
 */
class CountServersThatCanCommunicate {

    fun countServers(grid: Array<IntArray>): Int {
        val rows = mutableMapOf<Int,MutableList<Pair<Int,Int>>>()
        val columns = mutableMapOf<Int,MutableList<Pair<Int,Int>>>()
        val validServers = mutableSetOf<Pair<Int,Int>>()
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    rows.computeIfAbsent(i){ mutableListOf()}.add(Pair(i,j))
                    columns.computeIfAbsent(j){ mutableListOf()}.add(Pair(i,j))
                }
            }
        }
        rows.values.filter { it.size > 1 }.forEach { validServers.addAll(it) }
        columns.values.filter { it.size > 1 }.forEach { validServers.addAll(it) }

        return validServers.size

    }





}