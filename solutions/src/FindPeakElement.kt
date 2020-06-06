class FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return -1
        }
        return binarySearchPeak(nums,0,nums.lastIndex)

    }

    private fun binarySearchPeak(arr: IntArray, lower: Int, upper: Int) : Int {
        if (upper == lower) {
            return lower
        }
        val mid = lower + (upper-lower)/2
        if (arr[mid] > arr[mid+1]) {
            return binarySearchPeak(arr,lower,mid)
        }
        else {
            return binarySearchPeak(arr,mid+1,upper)
        }
    }

}