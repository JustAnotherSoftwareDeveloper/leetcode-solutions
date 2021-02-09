/**
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/submissions/
 */
class SortArrayByIncreasingFreq {
    fun frequencySort(nums: IntArray): IntArray {
        val freqMap = mutableMapOf<Int,Int>()
        nums.forEach {
            freqMap[it] = freqMap.getOrDefault(it,0)+1
        }
        val freqPairs = nums.map { Pair(freqMap[it]!!,it) }
        var freqCompare = compareBy<Pair<Int,Int>> { it.first }.thenByDescending { it.second }
        return freqPairs
                .sortedWith(freqCompare)
                .map { it.second }
                .toIntArray();
    }
}