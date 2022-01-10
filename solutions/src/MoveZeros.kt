/**
 * https://leetcode.com/problems/move-zeroes/submissions/
 */
class MoveZeros {

    fun moveZeros(nums: IntArray) {
        var insertpos = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[insertpos] = nums[i]
                insertpos++
            }
        }
        for (i in insertpos until nums.size) {
            nums[i] = 0
        }
    }
}