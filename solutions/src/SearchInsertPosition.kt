/**
 * https://leetcode.com/problems/search-insert-position/
 */
class SearchInsertPosition {

    fun searchInsert(nums: IntArray, target: Int): Int {
          if (nums.isEmpty()) {
              return 0
          }
        return searchInsertHelper(nums,target,0,nums.lastIndex)
    }


    private fun searchInsertHelper(nums: IntArray, target: Int, lo: Int, high: Int): Int {
        if (lo === high) {
            return if( nums[lo] == target) {
                lo
            } else if (nums[lo] > target) {
                lo
            } else {
                lo+1
            }
        }
        else {
            val mid = lo + (high-lo)/2
            return if (nums[mid] == target) {
                mid
            } else if (nums[mid] > target) {
                searchInsertHelper(nums,target,lo,mid)
            } else {
                searchInsertHelper(nums,target,mid+1,high)
            }
        }
    }
}