/**
 * https://www.hackerrank.com/challenges/cut-the-tree/problem
 *
 * The problem made it seem like a tree, but was actually an undirected graph.
 * I decided to just call it a day on this one
 */
class CutTreeEdge {
    fun cutTheTree(data: Array<Int>, edges: Array<Array<Int>>): Int {
        val totalSum = data.sum()
        val edgeMap = mutableMapOf<Pair<Int,Int>,Int>()
        val edgeToEnding = mutableMapOf<Int,Pair<Int,Int>>()
        val edgeSums = mutableMapOf<Pair<Int,Int>,Int>()
        val connectionsForward = mutableMapOf<Int,MutableList<Int>>()
        val connectionsReversed = mutableMapOf<Int,Int>()
        edges.forEachIndexed { index, ints ->
            edgeMap[Pair(ints[0],ints[1])] = index+1
            connectionsForward.computeIfAbsent(ints[0]-1){ mutableListOf()}.add(ints[1]-1)
            connectionsReversed[ints[1]-1] = ints[0]-1

        }

        val queue = mutableListOf<Int>()

        for (i in data.indices) {
            if (!connectionsForward.containsKey(i)) {
                queue.add(i)
            }
        }

        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0)
            if (connectionsReversed[current] != null) {
                val currentEdge = Pair(connectionsReversed[current]!!,current)
                val newSum = data[current] + connectionsForward.getOrDefault(current, mutableListOf()).map { edgeSums.getOrDefault(Pair(current,it),0) }.sum()
                edgeSums[currentEdge] = newSum
                queue.add(connectionsReversed[current]!!)
            }
        }

        var minPair = Pair(-1,-1)
        var minDifference = Int.MAX_VALUE

        for (edge in edgeSums.keys) {
            val difference = Math.abs(totalSum - edgeSums[edge]!!*2)
            if (difference < minDifference) {
                minDifference = difference
                minPair = edge
            }
        }

        return minDifference
    }
}