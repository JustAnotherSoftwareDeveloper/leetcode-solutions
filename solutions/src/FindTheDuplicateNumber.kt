//https://leetcode.com/problems/find-the-duplicate-number/
class FindTheDuplicateNumber {

    fun findDuplicate(nums: IntArray) : Int {
        var fast = nums[0]
        var slow = nums[0]

        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (fast != slow)

        var pointer1 = nums[0]
        var pointer2 = slow
        while (pointer1 != pointer2) {
            pointer1 = nums[pointer1]
            pointer2 = nums[pointer2]
        }
        return  pointer1
    }




}