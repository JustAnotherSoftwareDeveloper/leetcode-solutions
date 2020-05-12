/**
 * https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
 */
class MinTimeToCollectAllApples {
    fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>) : Int {
        val edgeMap = edges.map { Pair(it[0],it[1]) }.groupBy { it.first }.mapValues { entry -> entry.value.map { it.second } }
        return if (n > 1 && hasApple.any { it }) {
            dfs(setOf(0),edgeMap,hasApple,0)-2
        }
        else {
            0
        }
    }


    private fun dfs(visited: Set<Int>, edgeMap: Map<Int,List<Int>>, hasApple: List<Boolean>, node: Int ) : Int {
        val connections = edgeMap.getOrDefault(node, listOf()).filter { !visited.contains(it) }
        return if (connections.isEmpty() && hasApple[node])  {
            2
        }
        else if (connections.isEmpty() && !hasApple[node]) {
            0
        }
        else {
            val sum = connections.map { dfs(visited+node,edgeMap,hasApple,it) }.sum()
            if (sum > 0) {
                sum+2
            } else if (sum == 0 && hasApple[node]) {
                2
            }
            else {
                0
            }
        }
    }
}