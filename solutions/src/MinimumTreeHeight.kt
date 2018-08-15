import kotlin.math.min

class MinimumTreeHeight {
    // https://leetcode.com/problems/minimum-height-trees/description/

    fun findMinHeightTrees(n: Int, edges: Array<IntArray>) : List<Int> {
        val nodeToNeighbors : MutableMap<Int, MutableSet<Int>> = mutableMapOf()
        val visited: MutableSet<Int> = mutableSetOf()
        var removed = listOf<Int>()
        var shortest = Int.MAX_VALUE
        for(i in 0 until n) {
           nodeToNeighbors[i] = mutableSetOf()
        }
        for(edge in edges) { //O(E)
            nodeToNeighbors.getValue(edge[0]).add(edge[1])
            nodeToNeighbors.getValue(edge[1]).add(edge[0])
        }
        while (nodeToNeighbors.isNotEmpty()) { //O(log(n))
            removed = nodeToNeighbors.filterValues { it.size <= 1 }.keys.toList() //O(n)
            removed.forEach{nodeToNeighbors -= it}
            nodeToNeighbors.values.forEach { it.removeAll(removed) }


        }
        return removed




    }
}