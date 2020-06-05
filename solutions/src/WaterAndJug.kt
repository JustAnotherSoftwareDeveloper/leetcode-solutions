import kotlin.math.min

/**
 * https://leetcode.com/problems/water-and-jug-problem/
 */
class WaterAndJug {
    fun canMeasureWater(x: Int, y: Int, z: Int) : Boolean {
        val visited = mutableSetOf(Pair(0,0))
        val queue = mutableListOf(Pair(0,0))
        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0)
            if (current.first == z || current.second == z || current.first+current.second == z) {
                return true
            }
            val possibleCombos = mutableListOf(
                    Pair(0,current.second),
                    Pair(current.first,0),
                    Pair(x,current.second),
                    Pair(current.first,y)
            )
            var newRightJug: Int;
            var newLeftJug: Int
            val leftIntoRight = minOf(current.first,y-current.second)
            newRightJug = current.second+leftIntoRight
            newLeftJug = current.first - leftIntoRight

            possibleCombos.add(Pair(newLeftJug,newRightJug))
            val rightIntoLeft = minOf(current.second,x-current.first)
            newRightJug = current.second-rightIntoLeft
            newLeftJug = current.first +rightIntoLeft
            possibleCombos.add(Pair(newLeftJug,newRightJug))
            possibleCombos.filter { !visited.contains(it) }.forEach {
                queue.add(it)
                visited.add(it)
            }
        }



        return false
    }
}