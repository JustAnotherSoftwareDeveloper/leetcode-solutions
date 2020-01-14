class CombinationSumTwo {

    fun combinationSum2(candidates: IntArray, target: Int) : List<List<Int>> {
        val initialList = candidates.toList().groupingBy { it }.eachCount()
        val sums = mutableListOf<List<Int>>()
        var queue = mutableListOf(SumListWithMap(freqMap = initialList.toMutableMap()))
        while (queue.isNotEmpty()) {
            val item = queue.removeAt(0)
            if (item.sum == target) {
                sums.add(item.list)
            }
            else if (item.sum < target) {
                val newItems = item.freqMap.keys.map {
                    val mapCopy = item.freqMap.toMutableMap()
                    mapCopy[it]= mapCopy[it]!!-1;
                    if (mapCopy[it] == 0) {
                        mapCopy.remove(it)
                    }
                    val sum = item.sum+it
                    val newList = item.list+it
                    SumListWithMap(sum,newList.toMutableList(),mapCopy)
                }.filter { it.sum <= target }
                queue.addAll(newItems)
            }
        }



        return sums.map { it.sorted() }.distinct()
    }

    class SumListWithMap(var sum: Int = 0, val list: MutableList<Int> = mutableListOf(), val freqMap : MutableMap<Int,Int>)
}