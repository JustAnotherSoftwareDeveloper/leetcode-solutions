/**
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 */
class CheckIfNAndDoubleExist {

    fun checkIfExist(arr: IntArray) : Boolean {
        val doubles = arr.map{ it.toLong()*2 }.mapIndexed { index, l -> Pair(index,l)};
        val doubleMap : Map<Long,Set<Int>> = doubles.groupBy { it.second }.mapValues { it.value.map { p -> p.first }.toSet() }

        for(i in arr.indices) {
            val indiciesSet = doubleMap.getOrDefault(arr[i].toLong(), setOf()).toMutableSet();
            indiciesSet.remove(i);
            if (indiciesSet.isNotEmpty()) {
                return true;
            }
        }

        return false;
    }
}