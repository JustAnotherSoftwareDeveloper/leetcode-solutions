/**
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 */
class ElementAppearingMoreThan25Percent {
    fun findSpecialInteger(arr: IntArray): Int {
        val numByFreq = arr.toList().groupingBy { it }.eachCount()
        return numByFreq.maxBy { it.value }!!.key
    }
}