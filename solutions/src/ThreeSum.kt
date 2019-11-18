class ThreeSum {

    fun twoSum(nums: IntArray, target: Int) : List<List<Int>> {
        val compliments = mutableMapOf<Int,Int>()
        val sums = mutableSetOf<List<Int>>()
        nums.forEach {
            if (compliments.containsKey(it)) {
                sums.add(listOf(it,compliments[it]!!).sorted())
            }
            else {
                val compliment = target-it
                compliments[compliment] = it
            }
        }
        return sums.toList()
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return listOf()
        }
        val sums = mutableListOf<List<Int>>()
        nums.forEachIndexed { index, it ->
            val remaining  = 0 - it
            val withoutIt = when (index) {
                0 -> nums.slice(1..nums.lastIndex)
                nums.lastIndex -> nums.slice(0 until nums.lastIndex)
                else -> nums.slice(0 until index)+nums.slice(index+1 until nums.size)
            }.toIntArray()
            val twoSums = twoSum(withoutIt,remaining)
            twoSums.forEach{ list ->
                val sum = list+it
                sums.add(sum)
            }
        }
        return sums.map { it.sorted() }.toSet().toList()
    }
}