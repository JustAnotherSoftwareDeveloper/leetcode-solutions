/**
 * https://leetcode.com/problems/sort-colors/
 */
class SortColors {

    fun sortColors(nums: IntArray) {
        var start = 0
        var finish = nums.lastIndex
        var i = 0
        while (i <= finish) {
            while (nums[i]==2 && i < finish) {
                swap(nums,i,finish--)
            }
            while (nums[i] == 0 && i > start) {
                swap(nums,i,start++)
            }

            i++
        }
    }

    private fun swap(arr: IntArray, a: Int, b: Int) {
        val bVal = arr[b]
        arr[b] = arr[a]
        arr[a] = bVal
    }
}