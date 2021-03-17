/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */
class MostStonesRemoved {

    fun removeStones(stones: Array<IntArray>): Int {
        val stonePairs = stones.map { Pair(it[0],it[1]) }
        val visited = mutableSetOf<Pair<Int,Int>>()
        var numUnique = 0
        stonePairs.forEach {
            if (!visited.contains(it)) {
                numUnique++
                dfs(it,visited,stonePairs)
            }
        }
        return stonePairs.size- numUnique
    }


    private fun dfs(stone: Pair<Int,Int>, visited: MutableSet<Pair<Int,Int>>, stones: List<Pair<Int,Int>>) {
        visited.add(stone)
        stones.forEach {
            if (!visited.contains(it) && (stone.first == it.first || stone.second == it.second)) {
                dfs(it,visited,stones)
            }
        }
    }


}