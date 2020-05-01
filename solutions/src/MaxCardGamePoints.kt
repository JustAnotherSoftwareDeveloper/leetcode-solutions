/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
class MaxCardGamePoints {

    fun maxScore(cardPoints: IntArray, k: Int) : Int {
        var leftIndex = k-1
        var currTotal = 0
        for (i in 0 until k) {
            currTotal+=cardPoints[i]
        }
        var max = currTotal
        while (leftIndex >= 0) {
            val rightIndex = cardPoints.lastIndex - ((k-1)-leftIndex)
            currTotal-=cardPoints[leftIndex]
            currTotal+=cardPoints[rightIndex]
            max = maxOf(max,currTotal)
            leftIndex--
        }


        return max
    }
}