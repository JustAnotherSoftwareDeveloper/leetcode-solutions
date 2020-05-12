/**
 * https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/
 */
class MaxDiffYouCanGetFromChangingInteger {

    fun maxDiff(num: Int) : Int {
        val numMap = buildNumMap(num)
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for(x in 0 until 10) {
            for(y in 0 until 10) {
                val copyMap = numMap.toMutableMap()
                if (x != y) {
                    copyMap[x] = listOf()
                    copyMap[y] = numMap.getOrDefault(y, listOf()) + numMap.getOrDefault(x, listOf())
                }
                val newNum = buildNum(copyMap)
                if (newNum != 0) {
                    min = minOf(min,newNum)
                    max = maxOf(max,newNum)
                }
            }
        }
        return max-min
    }

    private fun buildNum(numMap: Map<Int,List<Int>>) : Int {
        val numList = numMap
                .flatMap { entry -> entry.value.map { Pair(it,entry.key) } }
                .sortedBy { it.first }
                .map { it.second }
        if (numList.isEmpty()) {
            return 0
        }
        else if (numList[0] == 0) {
            return 0
        }
        var number = 0
        for (i in numList.indices) {
            number*=10
            number+=numList[i]
        }
        return number;
    }

    private fun buildNumMap(number: Int) : Map<Int,List<Int>> {
        val numList = mutableListOf<Int>()
        var num = number
        while (num > 0) {
            numList.add(0,num % 10)
            num/=10
        }
        return numList
                .mapIndexed { index, i -> Pair(i,index) }
                .groupBy{it.first}
                .mapValues { entry -> entry.value.map { it.second } }
    }
}