class ContainerWithMostWater2025 {


    /**
     * https://leetcode.com/problems/container-with-most-water
     */

    fun maxArea(height: IntArray): Int {
        var maxArea = 0

        var left = 0
        var right = height.lastIndex

        while (right > left) {

            val currentArea = (right-left) * minOf(height[left],height[right])
            maxArea = maxOf(maxArea,currentArea)
            if (height[left] > height[right]) {
                right --

            }
            else {
                left++
            }
        }
        return maxArea
    }
}