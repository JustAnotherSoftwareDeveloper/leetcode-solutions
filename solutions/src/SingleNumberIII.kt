/**
 * https://leetcode.com/problems/single-number-iii/
 */
class SingleNumberIII {
    fun singleNumber(nums: IntArray) : IntArray {
        return nums
                .toList()
                .groupingBy { it }
                .eachCount()
                .filter { it.value == 1 }
                .map { it.key }
                .toIntArray()
    }
}