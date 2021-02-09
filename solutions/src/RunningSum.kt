/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
class RunningSum {

    fun runningSum(nums: IntArray) : IntArray {
        val sums = IntArray(nums.size){0};

        if (nums.isEmpty()) {
            return nums;
        }

        sums[0] = nums[0];

        for( i in 1 until nums.size) {
            sums[i] = nums[i]+sums[i-1];
        }


        return sums;
    }
}