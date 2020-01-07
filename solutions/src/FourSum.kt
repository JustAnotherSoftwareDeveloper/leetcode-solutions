class FourSum {

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        return NSum(nums,target,4).map { it.sorted() }.distinct()
    }
    private fun NSum(nums: IntArray, target: Int, N: Int): List<List<Int>> {
        if (N == 2) {
            return twoSum(nums, target)
        }
        else {
            val sums = mutableListOf<List<Int>>()
            nums.forEachIndexed { index, i ->
                val withoutIt = when (index) {
                0 -> nums.slice(1..nums.lastIndex)
                nums.lastIndex -> nums.slice(0 until nums.lastIndex)
                else -> nums.slice(0 until index)+nums.slice(index+1 until nums.size)
            }.toIntArray()
                val remaining = target - i
                sums.addAll(NSum(withoutIt,remaining,N-1).map { it+i })
            }
            return sums
        }
    }
    private fun twoSum(nums: IntArray, target: Int) : List<List<Int>> {
        val compliments = mutableMapOf<Int,Int>()
        val sums = mutableListOf<List<Int>>()
        nums.forEach {
            if (compliments[it]!= null) {
                sums.add(listOf(it,compliments[it]!!))
            }
            else {
                compliments[target-it] = it
            }
        }
        return sums.map { it.toList() }.toList()
    }



}