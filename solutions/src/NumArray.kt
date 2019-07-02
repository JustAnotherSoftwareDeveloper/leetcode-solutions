//https://leetcode.com/problems/range-sum-query-immutable/
class NumArray(  nums: IntArray) {
    val sums : List<Int>
    init {
        val sumsToCalc = mutableListOf<Int>()
        var sum = 0
        sumsToCalc.add(0)
        nums.forEach {
                sum += it
                sumsToCalc.add(sum)
        }
        sums = sumsToCalc.toList()
    }

    fun sumRange(i: Int, j: Int) : Int {
        return sums[j+1] - sums[i]

    }
}