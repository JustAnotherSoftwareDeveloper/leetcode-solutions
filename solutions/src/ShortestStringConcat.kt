import java.util.*

class ShortestStringConcat {
    fun shortestWay(src: String, target: String) :Int {
        val srcChars = mutableMapOf<Char, TreeSet<Int>>()

        src.forEachIndexed{index, c ->
            srcChars.computeIfAbsent(c) { TreeSet() }.add(index)
        }
        var minConcats = 0
        var minIndex = src.length
        var currString = "${target[0]}"
        target.forEachIndexed {index, targetChar ->
            currString+=targetChar
            if (!srcChars.containsKey(targetChar)) {
                return -1
            }
            val minTargetIndex = srcChars[targetChar]!!.ceiling(minIndex+1)

            when {
                minTargetIndex == null -> {
                    currString = ""
                    minConcats++
                    minIndex = srcChars[targetChar]?.min()!!
                }
                else -> {
                    minIndex = minTargetIndex

                }
            }
        }
        return minConcats
    }
}