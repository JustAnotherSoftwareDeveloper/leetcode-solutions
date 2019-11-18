class SearchRange {
    fun searchRange(nums: IntArray,target: Int): IntArray {
        return searchRangeRec(nums,target,0,nums.size-1)
    }

    private fun searchRangeRec(nums: IntArray, target: Int, low: Int, high: Int):IntArray {

        if (low > high) {
            return intArrayOf(-1,-1)
        }
        var minRange: Int
        var maxRange: Int
        var atIndex = low+(high-low)/2
        val searchLow = {searchRangeRec(nums,target,low,atIndex-1)}
        val searchHigh = {searchRangeRec(nums,target,atIndex+1,high)}
        return when {
            nums[atIndex] > target -> searchLow.invoke()
            nums[atIndex] < target -> searchHigh.invoke()
            else -> {
                minRange = atIndex
                maxRange = atIndex
                val minLeft = searchLow.invoke()[0]
                val maxRight = searchHigh.invoke()[1]
                if (minLeft !== -1) {
                    minRange = minLeft
                }
                if (maxRight != -1) {
                    maxRange = maxRight
                }
                return intArrayOf(minRange,maxRange)
            }
        }
    }

}