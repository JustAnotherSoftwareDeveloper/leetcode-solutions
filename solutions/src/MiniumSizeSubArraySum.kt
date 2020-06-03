import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
class MiniumSizeSubArraySum {
    fun minSubArrayLen(s: Int, nums: IntArray) : Int {
        if (nums.isEmpty()) {
            return 0
        }
        var minLength : Int? = null
        var lower = 0
        var upper = 0
        var sumAtLower = IntArray(nums.size)
        var sumUpper = IntArray(nums.size)
        val totalSum = nums.sum()
        for(i in nums.indices) {
            if (i == 0) {
                sumAtLower[0] = nums[0]
            }
            else {
                sumAtLower[i]=nums[i]+sumAtLower[i-1]
            }
        }
        for (i in nums.lastIndex downTo 0) {
            if (i == nums.lastIndex) {
                sumUpper[i] = nums[i]
            }
            else {
                sumUpper[i] = nums[i]+sumUpper[i+1]
            }
        }
        while (lower in 0..upper && upper < nums.size) {
            val sum = when {
                lower == 0 -> {
                    sumAtLower[upper]
                }
                upper == nums.lastIndex -> {
                    sumUpper[lower]
                }
                else -> {
                    totalSum - (sumAtLower[lower-1]+sumUpper[upper+1])
                }
            }
            if (sum >= s) {
                minLength = minOf(1 + (upper- lower), minLength ?: Int.MAX_VALUE)
                lower++
            }
            else {
                upper++
            }
        }
        return minLength ?: 0
    }
}