/**
 * https://leetcode.com/problems/ways-to-make-a-fair-array/
 *
 * Got correct big O(N) complexity but timeout still reached
 */
class WaysToMakeFairArray {


    fun waysToMakeFair(nums: IntArray): Int {

        var sumEven = 0
        var sumOdd = 0
        val sumEvenAscending = mutableListOf<Int>()
        val sumOddAscending = mutableListOf<Int>()
        val sumEvenDescending = mutableListOf<Int>()
        val sumOddDescending = mutableListOf<Int>()

        for (i in nums.indices) {
            if (i % 2 == 0) {
                sumEven+=nums[i]
            }
            else {
                sumOdd+=nums[i]
            }
            sumEvenAscending.add(sumEven)
            sumOddAscending.add(sumOdd)
        }
        sumEven = 0
        sumOdd = 0
        for (i in nums.lastIndex downTo 0) {
            if (i % 2 == 0) {
                sumEven+=nums[i]
            }
            else {
                sumOdd+=nums[i]
            }
            sumEvenDescending.add(0,sumEven)
            sumOddDescending.add(0,sumOdd)
        }

        var ways = 0

        if (nums.size == 1) {
            return 1
        }
        for (i in nums.indices) {
            if (i == 0) {
                if (sumEvenDescending[i+1] == sumOddDescending[i+1]) {
                    ways++
                }
            }
            else if (i == nums.lastIndex) {
                if (sumEvenAscending[i-1] == sumOddAscending[i-1]) {
                    ways++
                }
            }
            else {
                val newOddSum = sumOddAscending[i-1]+sumEvenDescending[i+1]
                val newEvenSum = sumEvenAscending[i-1]+sumOddDescending[i+1]
                if (newEvenSum == newOddSum) {
                    ways++
                }
            }
        }
        return ways

    }


}