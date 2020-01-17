import java.util.*

/**
 * Not my code
 */
class ContinousSubarraySum {

    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val map = mutableMapOf(Pair(0,-1))
        var runningSum = 0
        for (i in nums.indices) {
            runningSum += nums[i]
            if (k != 0) runningSum %= k
            val prev = map[runningSum]
            if (prev != null) {
                if (i - prev > 1) return true
            } else map[runningSum] = i
        }
        return false
    }
}