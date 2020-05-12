import java.util.*

/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */
class LongestContinuousSubarrayWithAbsoluteDiff {

    fun longestSubarray(nums : IntArray, limit: Int) : Int {
        if (nums.isEmpty() || limit < 0) {
            return 0
        }
        var maxLength = 1
        val currSet = TreeMap<Int,Int>()
        currSet[nums[0]] = 1
        val currList = mutableListOf<Int>(nums[0])
        var i = 0
        var j = 1
        while (i <= j && j < nums.size) {
            val currNum = nums[j]
            val diff = if (currSet.isEmpty()) 0 else maxOf(currSet.lastKey(),currNum) - minOf(currSet.firstKey() ,currNum)
            if (diff <= limit) {
                currList.add(currNum)
                currSet[currNum] = currSet.getOrDefault(currNum,0)+1
                maxLength = maxOf(maxLength,currList.size)
                j++
            }
            else {
                val toRemove = currList.removeAt(0)
                currSet[toRemove] = currSet.getOrDefault(toRemove,0)-1
                if (currSet.getOrDefault(toRemove,0) < 1) {
                    currSet.remove(toRemove)
                }
                i++
            }
        }
        return maxLength
    }
}