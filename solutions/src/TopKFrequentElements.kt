import java.util.*
import kotlin.Comparator

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int) : IntArray {
        val elementsByCount = nums.toList().groupingBy { it }.eachCount()
        val priorityCompare : Comparator<Pair<Int,Int>> = Comparator { o1, o2 ->
         o2.second.compareTo(o1.second)
        }
        val priorityQueue = PriorityQueue(priorityCompare)
        elementsByCount.forEach {
            priorityQueue.add(Pair(it.key,it.value))
        }
        val topK = mutableListOf<Int>()
        for (i in 1..k) {
            topK.add(priorityQueue.poll().first)
        }
        return topK.toIntArray()
    }
}