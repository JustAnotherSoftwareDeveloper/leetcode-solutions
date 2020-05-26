/**
 * https://leetcode.com/problems/letter-tile-possibilities/
 */
class LetterTilePossibilities {
    fun numTilePossibilities(tiles: String): Int {
        if (tiles.isEmpty()) {
            return 0
        }
        val charsToCount = tiles.groupingBy { it }.eachCount()
        val queue = mutableListOf(QueueItem(charsToCount))
        var visited : Int = -1
        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0)
            visited++
            println(current.s)
            if (current.charMap.isEmpty()) {
                continue
            }
            else {
                current.charMap.keys.forEach {
                    val newMap = current.charMap.toMutableMap()
                    newMap[it] = newMap.getOrDefault(it,0)-1
                    if (newMap.getOrDefault(it,0) == 0) {
                        newMap.remove(it)
                    }
                    queue.add(QueueItem(newMap,current.s+it))

                }
            }
        }
        return visited
    }

    private class QueueItem(val charMap : Map<Char,Int>, val s: String = "")


}