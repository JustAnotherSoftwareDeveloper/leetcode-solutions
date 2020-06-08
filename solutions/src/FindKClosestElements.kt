import java.util.*
import kotlin.Comparator
import kotlin.math.abs

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 */
class FindKClosestElements {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val compareToX : Comparator<Int> = Comparator{i1, i2 ->
            val i1Compare = abs(i1-x)
            val i2Compare = abs(i2-x)
            if (i1Compare > i2Compare) {
                1
            }
            else if (i1Compare < i2Compare) {
                -1
            }
            else {
                i1.compareTo(i2)
            }
        }
        val pQueue = PriorityQueue(compareToX);
        arr.forEach { pQueue.add(it) }
        val returnList = mutableListOf<Int>()
        for (i in 0 until k) {
            returnList.add(pQueue.poll())
        }
        return returnList.sorted()
    }
}