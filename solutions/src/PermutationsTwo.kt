class PermutationsTwo {

    fun permuteUnique(nums: IntArray) : List<List<Int>> {

        val baseMap = nums.toList().groupingBy { it }.eachCount()
        val permutations = mutableListOf<List<Int>>()
        val queue = mutableListOf(PermuationTwo(map = baseMap))

        while(queue.isNotEmpty()) {
            val item = queue.removeAt(0)
            if (item.list.size == nums.size) {
                permutations+=item.list
            }
            else if (item.list.size < nums.size) {
                queue+=item.map.keys.map {
                    val cloneMap = item.map.toMutableMap()
                    cloneMap[it] = cloneMap[it]!!-1
                    if (cloneMap[it] == 0) {
                        cloneMap.remove(it)
                    }
                    val cloneList = item.list+it
                    PermuationTwo(cloneList,cloneMap)
                }
            }
        }



        return permutations
    }

    private class PermuationTwo(val list: List<Int> = listOf(), val map: Map<Int,Int>)
}