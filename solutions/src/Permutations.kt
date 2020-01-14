class Permutations {

    fun permute(nums: IntArray) : List<List<Int>> {
        val permutations = mutableListOf<List<Int>>()
        val queue = mutableListOf(Permutation(set = nums.toSet()))
        while(queue.isNotEmpty()) {
            val item = queue.removeAt(0)
            if (item.list.size == nums.size) {
                permutations+=item.list
            }
            else if (item.list.size < nums.size) {
                queue+=item.set.map {
                    val cloneSet = item.set.toMutableSet()
                    cloneSet.remove(it)
                    val cloneList = item.list+it
                    Permutation(cloneList,cloneSet)
                }
            }
        }
        return permutations

    }

    private class Permutation(val list: List<Int> = listOf(), val set: Set<Int>)
}