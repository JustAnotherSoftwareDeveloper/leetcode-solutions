import kotlin.math.roundToInt

//https://leetcode.com/problems/search-in-rotated-sorted-array/
class SearchRotatedSortedArray {


    fun search(nums: IntArray, target: Int) : Int {
        val pivot = findPivot(nums, 0, nums.lastIndex)


        if (pivot == -1)
            return Math.max(nums.binarySearch(target),-1)

        if (nums[pivot] === target)
            return pivot
        return if (nums[0] <= target) Math.max(nums.binarySearch(target,toIndex = pivot),-1) else Math.max(nums.binarySearch(target, fromIndex = pivot+1),-1)


    }

    private fun findPivot(arr: IntArray, low: Int, high: Int): Int {

        if (high < low)
            return -1
        if (high == low)
            return low

        val mid = (low + high) / 2
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid
        if (mid > low && arr[mid] < arr[mid - 1])
            return mid - 1
        return if (arr[low] >= arr[mid]) findPivot(arr, low, mid - 1) else findPivot(arr, mid + 1, high)
    }
}
