/**
 * https://leetcode.com/problems/house-robber/
 */
class HouseRobber {
    fun rob(nums: IntArray) : Int {
        var toRob = 0
        var dontRob = 0
        for(i in nums.indices) {
            val robbing = dontRob+nums[i]
            dontRob = maxOf(dontRob,toRob)
            toRob = robbing
        }
        return maxOf(toRob,dontRob)
    }
}