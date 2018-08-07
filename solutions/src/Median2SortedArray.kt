class Median2SortedArray {

    fun findMedianSortedArrays(nums1: IntArray, nums2:IntArray): Double {
        // https://leetcode.com/problems/median-of-two-sorted-arrays/description/
        var indexOne = 0
        var indexTwo = 0
        val merged : ArrayList<Int> = ArrayList()
        while (indexOne < nums1.size || indexTwo < nums2.size) {
            if (indexOne >= nums1.size) {
                merged.add(nums2[indexTwo])
                indexTwo++
            }
            else if (indexTwo >= nums2.size) {
                merged.add(nums1[indexOne])
                indexOne++
            }
            else {
                val num1Val = nums1[indexOne]
                val num2Val = nums2[indexTwo]
                if (num1Val < num2Val) {
                    merged.add(num1Val)
                    indexOne++
                }
                else {
                    merged.add(num2Val)
                    indexTwo++
                }
            }
        }
        if (merged.size % 2 == 1) {
            return merged.get(merged.size/2).toDouble()
        }
        else {
            return (merged.get(merged.size/2) + merged.get((merged.size/2)-1))/2.0
        }
    }
}