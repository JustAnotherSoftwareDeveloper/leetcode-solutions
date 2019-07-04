//https://leetcode.com/problems/range-sum-query-mutable/
class NumArrayMutable(nums: IntArray) {

    val valByIndex : MutableMap<Int,Int> = mutableMapOf()
    val sums : MutableList<Int> = mutableListOf()
    init {
        sums.add(0)
        nums.forEachIndexed{index, it ->
            valByIndex[index] = it
            sums.add(it+sums[index])
        }
    }

    // O(n)
    fun update(i: Int, `val`: Int) {
        println("Update: $i $`val`")
        val current = valByIndex[i]!!
        val difference = `val` - current
        valByIndex[i] = `val`
        for (j in i+1 until sums.size) {
            sums[j]+= difference
        }
    }
    // O(1)
    fun sumRange(i: Int, j: Int) : Int {
        println("Sum: ${sums[j+1] - sums[i]}")
        return sums[j+1] - sums[i]
    }
}