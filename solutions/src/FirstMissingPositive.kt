/**
 * https://leetcode.com/problems/first-missing-positive/
 */
class FirstMissingPositive {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        for (i in 0 until n) {
            while (nums[i] in 1..n && nums[i] != nums[nums[i] - 1]) swap(nums, i, nums[i] - 1)
        }
        for (i in 0 until n) if (nums[i] != i + 1) return i + 1
        return n + 1
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        nums[i] = nums[i] xor nums[j]
        nums[j] = nums[j] xor nums[i]
        nums[i] = nums[i] xor nums[j]
    }
}