/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
class AllNodesFromSrcToTarget {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val edges = mutableMapOf<Int,MutableList<Int>>()

        graph.forEachIndexed { index, ints ->
            edges.computeIfAbsent(index){ mutableListOf()}.addAll(ints.toList())
        }
        return bfs(0, mutableSetOf(),edges, mutableListOf(),graph.size-1)
    }

    fun bfs(current: Int, visited: MutableSet<Int>, edges: Map<Int,List<Int>>, path: MutableList<Int>, target: Int) : List<List<Int>> {
        if (visited.contains(current)) {
            return listOf()
        }
        path.add(current)
        visited.add(current)
        if (target == current) {
            return listOf(path)
        }
        val list = edges.getOrDefault(current, listOf()).map {
            bfs(it,visited.toMutableSet(),edges,path.toMutableList(),target)
        }
        if (list.isEmpty()) {
            return listOf()
        }
        else {
            return list.reduce { acc, list -> list+acc }
        }
    }

}