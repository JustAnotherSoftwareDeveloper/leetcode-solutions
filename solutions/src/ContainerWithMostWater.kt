import kotlin.test.currentStackTrace

class ContainerWithMostWater {
    fun maxArea(height: IntArray) : Int {
        var maxarea = 0
        var left = 0
        var right = height.lastIndex
        while (left < right) {
            maxarea = maxOf(maxarea, minOf(height[left],height[right])*(right-left))
            if (height[left] < height[right]) {
                left++
            }
            else {
                right--
            }
        }
        return maxarea
    }
}