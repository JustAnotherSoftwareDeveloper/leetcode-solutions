class TrapRainWater {

    fun trap(height: IntArray) : Int {
        var totalWater =0
        var currentContainer = 0
        var currentBarrier = 0
        var maxHeight = 0
        val maxHeightAt = arrayOfNulls<Int>(height.size)
        for (i in height.lastIndex downTo 0) {
            maxHeight = maxOf(maxHeight,height[i])
            maxHeightAt[i] = maxHeight
        }

        for (i in height.indices) {

            if (height[i] >= currentBarrier) {
                totalWater+=currentContainer
                currentContainer = 0
                currentBarrier = if (i != height.lastIndex) minOf(height[i],maxHeightAt[i+1]!!) else height[i]
            }
            else {
                currentContainer+=(currentBarrier - height[i])
            }
        }
        return totalWater
    }
}