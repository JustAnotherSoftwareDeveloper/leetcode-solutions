/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/submissions/
 */
class RemoveDuplicatesFromSortedArrayTwo {

    fun removeDuplicates(nums: IntArray) : Int {
        if (nums.isEmpty()) {
            return 0
        }
        var currNum = nums[0]
        var currentIndex = 0
        var timesSeen = 1
        for (i in 1 until nums.size) {
            if (currNum < nums[i]) {
                currNum = nums[i]
                timesSeen = 1
                currentIndex++
                swap(nums,i,currentIndex)
            }
            else if (currNum == nums[i]){
                timesSeen++
                if (timesSeen <= 2) {
                    currentIndex++
                    swap(nums,i,currentIndex)
                }

            }
        }
        println(nums.toList())
        return currentIndex+1
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }
}