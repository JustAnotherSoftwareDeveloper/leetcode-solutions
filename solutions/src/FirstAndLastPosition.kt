class FirstAndLastPosition {

    fun searchRange(nums: IntArray, target: Int): IntArray {
        var low = -1
        var high = -1
        var minIndex = 0
        var maxIndex = nums.size
        while( maxIndex >= minIndex && nums.binarySearch(target,minIndex,maxIndex) >= 0) {

            maxIndex = nums.binarySearch(target,minIndex,maxIndex)
            low = maxIndex

        }
        minIndex = 0
        maxIndex = nums.size
        while(minIndex in 0 until maxIndex && nums.binarySearch(target,minIndex,maxIndex) >= 0) {
            minIndex = nums.binarySearch(target,minIndex,maxIndex)
            high = minIndex
            minIndex++
        }
        return intArrayOf(low,high)
    }
}