/**
 * https://leetcode.com/problems/map-of-highest-peak/
 *
 * Time Limit Exceeded, but same O(N) complexity (O(m*n)) as accepted solution
 */
class FindHighestPeak {
    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {

        val queue = mutableListOf<Space>()
        val visited = mutableSetOf<Pair<Int,Int>>()
        for (i in isWater.indices) {
            for (j in isWater[0].indices) {
                if (isWater[i][j] == 1) {
                    queue.add(Space(Pair(i,j),0))
                    visited.add(Pair(i,j))
                }
            }
        }
        val returnArray = Array(isWater.size){IntArray(isWater[0].size)}
        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0)
            val point = current.point
            returnArray[point.first][point.second] = current.height
            listOf(
                    Pair(point.first+1,point.second),
                    Pair(point.first-1,point.second),
                    Pair(point.first,point.second+1),
                    Pair(point.first,point.second-1)
            )
                    .filter { !visited.contains(it) && !(it.first < 0 || it.first >= isWater.size || it.second < 0 || it.second >= isWater[0].size) }
                    .forEach {
                        visited.add(it)
                        queue.add(Space(it,current.height+1))
                    }
        }
        return returnArray
    }


    private data class Space(val point: Pair<Int,Int>, val height : Int)

}