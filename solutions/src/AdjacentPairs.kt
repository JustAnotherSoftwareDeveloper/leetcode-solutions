/**
 * https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
 */
class AdjacentPairs {

    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {

        val adjacentList = adjacentPairs.map { it.toList().sorted() }.map { Pair(it[0],it[1]) }
        val adjacentFreq = mutableMapOf<Int,Int>()
        adjacentPairs.forEach {
            adjacentFreq[it[0]] = adjacentFreq.getOrDefault(it[0],0)+1
            adjacentFreq[it[1]] = adjacentFreq.getOrDefault(it[1],0)+1
        }
        val adjacentMapForward = adjacentList.groupBy { it.first }.mapValues { it.value.map { p -> p.second }.toSet() }
        val adjacentMapBackwards = adjacentList.map { Pair(it.second,it.first) }.groupBy { it.first }.mapValues { it.value.map { p -> p.second }.toSet() }
        val firstValue = adjacentFreq.filter { it.value == 1 }.map { it.key }[0]

        var currentValue : Int? = firstValue

        val visited = mutableSetOf(firstValue)
        var returnList = mutableListOf<Int>()
        returnList.add(currentValue!!)
        visited.add(currentValue!!)
        while (currentValue != null) {

            val forward = adjacentMapForward[currentValue]
            val backward = adjacentMapBackwards[currentValue]

            val valueList = listOfNotNull(forward, backward).flatten().filter { it != null && !visited.contains(it) }
            if (valueList.isEmpty()) {
                currentValue = null
            }
            else {
                currentValue = valueList[0]
                returnList.add(currentValue)
                visited.add(currentValue)
            }
        }
        return returnList.toIntArray()

    }

}