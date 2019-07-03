import kotlin.math.max
import kotlin.math.min

//https://leetcode.com/problems/maximum-subarray/
class MaximumSubarray {
    fun maxSubArray(nums: IntArray) : Int {
        var currMax  = Int.MIN_VALUE
        var maxEncountered = Int.MIN_VALUE
        nums.forEach {
            if (currMax < 0) {
                currMax = it
            }
            else {
                currMax +=it
            }
            maxEncountered = max(currMax, maxEncountered)
        }
        return maxEncountered
    }
}