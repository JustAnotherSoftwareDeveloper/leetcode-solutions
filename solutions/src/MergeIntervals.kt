import kotlin.math.max

//https://leetcode.com/problems/merge-intervals/
class MergeIntervals {
    fun merge(intervals: Array<IntArray>) : Array<IntArray> {
        if (intervals.isEmpty()) {
            return arrayOf()
        }
        val mergedArrays = mutableListOf<IntArray>()

        val sortedIntervals = intervals.sortedBy { it[0] } // n log(n)

        var intervalStart = sortedIntervals[0][0]
        var intervalEnd = sortedIntervals[0][1]
        sortedIntervals.forEach{
            if (intervalEnd >= it[0]) {
                intervalEnd = max(intervalEnd, it[1])
            }
            else {
                mergedArrays.add(intArrayOf(intervalStart,intervalEnd))
                intervalStart = it[0]
                intervalEnd = it[1]

            }
        }
        mergedArrays.add(intArrayOf(intervalStart,intervalEnd))


        return mergedArrays.toTypedArray()
    }
}