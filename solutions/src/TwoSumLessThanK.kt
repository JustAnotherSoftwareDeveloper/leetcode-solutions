import java.util.*

class TwoSumLessThanK {

    fun twoSumLessThanK(A: IntArray, K: Int) : Int {
        val maxValueMap = TreeMap<Int,Int>()
        var maxValue = -1

        A.forEach {
            val compliment = K - it
            val closestTo = maxValueMap.floorEntry(compliment-1)
            println("Value : $it Compliment: $compliment, ClosestTo: $closestTo")
            if (closestTo != null) {
                maxValue = maxOf(maxValue,it+closestTo.key)
            }
            maxValueMap[it] = compliment
        }

        return maxValue
    }
}