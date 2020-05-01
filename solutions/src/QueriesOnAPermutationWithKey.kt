import java.util.*

/**
 * https://leetcode.com/problems/queries-on-a-permutation-with-key/
 */
class QueriesOnAPermutationWithKey {

    fun processQueries(queries: IntArray, m: Int) : IntArray {
        val queryPositions = mutableListOf<Int>()
        val permutationToPosition = TreeMap<Int,Int>()
        val positionToPermutation = TreeMap<Int,Int>()
        for (i in 1..m) {
            permutationToPosition[i] = i-1
            positionToPermutation[i-1] = i
        }
        for (i in queries.indices) {
            val permutation = queries[i]
            val index = permutationToPosition[permutation]!!
            val oldPositionToPermutations = TreeMap(positionToPermutation)
            oldPositionToPermutations.headMap(index,false).entries.forEach {
                val key = it.key
                val value = it.value
                permutationToPosition[value] = key+1
                positionToPermutation[key+1] = value
            }
            permutationToPosition[permutation] = 0
            positionToPermutation[0] = permutation
            queryPositions.add(index)

        }
        return queryPositions.toIntArray()
    }
}