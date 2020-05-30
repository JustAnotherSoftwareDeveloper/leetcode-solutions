import kotlin.math.abs

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 */
class ContainsDuplicateIII {
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        if (nums.isEmpty()) {
            return false
        }
        for(i in nums.indices) {
            for(j in 0..k) {
                if (i+j < nums.size && i != i+j && abs(nums[i].toLong()-nums[i+j].toLong()) <= t) {
                    return true
                }
            }
        }
        return false
    }
}