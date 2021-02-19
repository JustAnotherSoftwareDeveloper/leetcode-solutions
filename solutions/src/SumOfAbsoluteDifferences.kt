/**
 * https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
 */
class SumOfAbsoluteDifferences {

    fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
        val returnArray = IntArray(nums.size)
        val numsSolutions = mutableMapOf<Int,Int>()


        val numsSorted = nums.sorted();

        var sum = 0
        val sumAt = mutableListOf<Int>()

        for (i in numsSorted.indices) {
            sum+=numsSorted[i]
            sumAt.add( sum)
        }

        for (i in numsSorted.indices) {
            val numToTest = numsSorted[i]
            var differenceSum = 0
            if (i-1 >= 0) {
                val lowerDiff = (numToTest*i) - sumAt[i-1]
                differenceSum+=lowerDiff
            }
            if (i+1 < numsSorted.size) {
                val higerDiff = ((sumAt[sumAt.lastIndex]-sumAt[i]) - (numToTest*(numsSorted.lastIndex-i)))
                differenceSum+= higerDiff
            }

            numsSolutions[numToTest] = differenceSum
        }

        return nums.map { numsSolutions[it]!! }.toIntArray()


    }
}