
//https://leetcode.com/problems/partition-labels/
class PartitionLabels {

    fun partitionLabels(S: String) : List<Int> {
        val maxIndexs: MutableMap<Char,Int> = mutableMapOf()
        S.forEachIndexed { index, c ->
            maxIndexs[c] = maxOf(index, maxIndexs[c] ?: Int.MIN_VALUE)
        }
        val returnlist = mutableListOf<Int>()
        var returnString = ""
        var currentMax = 0
        S.forEachIndexed { index, c ->
            returnString+=c
            currentMax = maxOf(maxIndexs[c]!!,currentMax)
            if (currentMax == index) {
                returnlist.add(returnString.length)
                returnString = ""
            }
        }
        return returnlist
    }

}