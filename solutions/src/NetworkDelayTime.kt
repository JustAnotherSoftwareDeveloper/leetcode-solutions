import java.util.*
import kotlin.collections.HashSet

//https://leetcode.com/problems/network-delay-time/
class NetworkDelayTime {

    fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
        val graph = createGraph(times)
        val distances : MutableMap<Int,Node> = mutableMapOf()
        val explored: MutableSet<Int> = HashSet()
        for (i in 1..N) {
            val node =
                    if (i == K) {
                        Node(i, 0)
                    } else {
                        Node(i)
                    }
            distances[i] = node

        }
        val unexplored = distances.values.sortedBy { it.distance }.toMutableList()
        while (unexplored.isNotEmpty()) {
            val current = unexplored.removeAt(0)
            graph.getOrDefault(current.id, listOf())
                    .filter { !explored.contains(it.to) }
                    .forEach {
                        var node = distances[it.to]!!
                        var tmpDistance = current.distance + it.cost
                        if (tmpDistance < node.distance) {
                            node.distance = tmpDistance
                            unexplored.sortBy { node -> node.distance }
                        }
                    }
            explored.add(current.id)
        }

        return if (distances.values.any { it.distance == Int.MAX_VALUE }) {
            -1
        } else {
            return distances.values.map { it.distance }.max()!!
        }


    }

    fun createGraph(times: Array<IntArray>): Map<Int, List<Edge>> {
        return times.map {
            Edge(it[0], it[1], it[2])
        }.groupBy { it.from }
    }

    data class Edge(val from: Int, val to: Int, val cost: Int)

    data class Node(val id: Int, var distance: Int = Int.MAX_VALUE)


}

