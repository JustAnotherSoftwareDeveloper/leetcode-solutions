/**
 * https://leetcode.com/problems/house-robber-ii/
 */
class HouseRobberTwo {

    fun rob(nums: IntArray) : Int {
        if (nums.isEmpty()) {
            return 0
        }
        if (nums.size < 2) {
            return nums[0]
        }
        val firstHouse = IntArray(nums.size+1)
        val secondHouse = IntArray(nums.size+1)
        firstHouse[1] = nums[0]
        for(i in 2 until firstHouse.size) {
            firstHouse[i] = maxOf(firstHouse[i-1],firstHouse[i-2]+nums[i-1])
            secondHouse[i] = maxOf(secondHouse[i-1],secondHouse[i-2]+nums[i-1])
        }
        return maxOf(firstHouse[nums.lastIndex],secondHouse[nums.size])
    }
}