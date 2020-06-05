import java.util.*

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
class FindKPairsWithSmallestSum {

    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        var pairSums: MutableList<Pair<Int, List<Int>>> = mutableListOf()
        val m = minOf(nums1.size, k)
        val n = minOf(nums2.size, k)
        for (i in 0 until m) {
            for (j in 0 until n) {
                pairSums.add(Pair(nums1[i] + nums2[j], listOf(nums1[i], nums2[j])))
            }
        }
        val seenSums = mutableSetOf<Int>()
        val returnSums = mutableListOf<List<Int>>()
        pairSums = pairSums.sortedBy { it.first }.toMutableList()
        return if (pairSums.size < k) pairSums.map { it.second } else pairSums.subList(0,k).map { it.second }
    }

}