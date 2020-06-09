
import java.util.*

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
class ShortestUnsortedContinuousSubArray {
    fun findUnsortedSubarray(nums: IntArray): Int {
        val stack = Stack<Int>()
        var l = nums.size
        var r = 0
        for (i in nums.indices) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) l = Math.min(l, stack.pop())
            stack.push(i)
        }
        stack.clear()
        for (i in nums.indices.reversed()) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) r = Math.max(r, stack.pop())
            stack.push(i)
        }
        return if (r - l > 0) r - l + 1 else 0
    }
}