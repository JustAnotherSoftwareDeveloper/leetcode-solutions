/**
 * https://leetcode.com/problems/number-of-provinces/
 */
class NumberOfProvinces {

    fun findCircleNum(M: Array<IntArray>): Int {
        val edges = mutableMapOf<Int,MutableList<Int>>()

        for (i in M.indices) {
            for (j in M[0].indices) {
                if (M[i][j] == 1) {
                    edges.computeIfAbsent(i){ mutableListOf()}.add(j)
                }
            }
        }

        val visited = mutableSetOf<Int>()
        var numProvinces = 0
        for (i in M.indices) {
            if (!visited.contains(i)) {
                numProvinces++
                dfs(i,visited,edges)
            }
        }
        return numProvinces
    }


    private fun dfs(city: Int, visited: MutableSet<Int>,edges: Map<Int,List<Int>>) {
        if (visited.contains(city)) {
            return
        }
        visited.add(city)
        val cityRoads = edges.getOrDefault(city, listOf())
        for (connectedCity in cityRoads) {
            dfs(connectedCity,visited,edges)
        }
    }
}