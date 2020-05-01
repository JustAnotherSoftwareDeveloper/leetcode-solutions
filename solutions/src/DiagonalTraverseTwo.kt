import java.util.ArrayList
import java.util.HashMap
import java.util.LinkedList


/**
 * https://leetcode.com/problems/diagonal-traverse-ii/submissions/
 */
class DiagonalTraverseTwo {

    fun findDiagonalOrder(nums: List<List<Int>>): IntArray? {
        var size = 0
        val map: MutableMap<Int, LinkedList<Int>> = HashMap()
        for (i in nums.indices) {
            val numList = nums[i]
            for (j in numList.indices) {
                val index = i + j
                var list = map[index]
                if (list == null) {
                    list = LinkedList()
                }
                list.addFirst(numList[j])
                map[index] = list
                size++
            }
        }
        val maxLen: Int = map.keys.max()!!
        val resultList: MutableList<Int> = ArrayList()
        for (i in 0..maxLen) {
            val diagValue: List<Int> = map[i]!!
            resultList.addAll(diagValue)
        }
        val res = IntArray(resultList.size)
        for (i in res.indices) {
            res[i] = resultList[i]
        }
        return res
    }
}