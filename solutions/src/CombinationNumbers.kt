class CombinationNumbers {
    fun combinationSum(candidates: IntArray, target: Int) : List<List<Int>> {
        val queue = mutableListOf(SumList())
        val sums = mutableListOf<List<Int>>()
        while (queue.isNotEmpty()) {
            val sumList = queue.removeAt(0)
            if (sumList.sum == target) {
                sums.add(sumList.list)
            }
            else if (sumList.sum < target) {
                queue+=candidates.map {
                    val newList = sumList.list.toList()+it
                    val newSum = sumList.sum+it
                    SumList(newSum,newList.toMutableList())
                }.filter { it.sum <= target }
            }
        }
        return sums.map { it.sorted() }.distinct()
    }

    class SumList(var sum : Int = 0, var list: MutableList<Int> = mutableListOf())

}