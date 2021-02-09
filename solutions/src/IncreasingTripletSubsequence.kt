/**
 * https://leetcode.com/problems/increasing-triplet-subsequence
 */
class IncreasingTripletSubsequence {

    fun increasingTriplet(nums: IntArray) : Boolean {
        if (nums.isEmpty()) {
            return false
        }
        var first = Int.MAX_VALUE
        var second = Int.MAX_VALUE
        for (i in nums.indices) {
            when {
                nums[i] <= first -> {
                    first = nums[i]
                }
                nums[i] <= second -> {
                    second = nums[i]
                }
                else -> {
                    return true;
                }
            }
        }

        return false;
    }
}