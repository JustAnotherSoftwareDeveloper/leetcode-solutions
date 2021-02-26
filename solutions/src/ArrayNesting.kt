/**
 * https://leetcode.com/problems/array-nesting/
 */
class ArrayNesting {

    fun arrayNesting(nums: IntArray) : Int {


        var maxLength = 0
        for (i in nums.indices) {
            var currentLength = 0
            var currentIndex: Int? = i
            while (currentIndex != null) {
                currentLength++
                val nextIndex = nums[currentIndex]
                currentIndex = nextIndex
                if (currentIndex == i) {
                    currentIndex = null
                }
            }
            maxLength = maxOf(maxLength,currentLength)
        }
        return maxLength
    }

}