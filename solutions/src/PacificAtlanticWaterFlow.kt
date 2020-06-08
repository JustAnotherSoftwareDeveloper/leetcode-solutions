/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
class PacificAtlanticWaterFlow {

    fun pacificAtlantic(matrix: Array<IntArray>): List<List<Int>> {
        if (matrix.isEmpty()) {
            return listOf()
        }
        var pathToAtlanticFromPacific = mutableSetOf<Pair<Int,Int>>()
        var pathToPacificFromAtlantic = mutableSetOf<Pair<Int,Int>>()
        val pathToFromBoth = mutableSetOf<Pair<Int,Int>>()
        val m = matrix.size
        val n = matrix[0].size
        //Pacific
        for (i in matrix.indices) {
            val currentPoint = Pair(i,0)
            dfs(pathToAtlanticFromPacific,currentPoint,matrix,Int.MIN_VALUE)
        }
        for (i in matrix[0].indices) {
            val currentPoint = Pair(0,i)
            dfs(pathToAtlanticFromPacific,currentPoint,matrix,Int.MIN_VALUE)
        }
        for (i in matrix.indices) {
            val currentPoint = Pair(i,matrix[0].lastIndex)
            dfs(pathToPacificFromAtlantic,currentPoint,matrix,Int.MIN_VALUE)
        }
        for (i in matrix[0].indices) {
            val currentPoint = Pair(matrix.lastIndex,i)
            dfs(pathToPacificFromAtlantic,currentPoint,matrix,Int.MIN_VALUE)
        }
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                val currentPoint = Pair(i,j)
                if (pathToAtlanticFromPacific.contains(currentPoint) && pathToPacificFromAtlantic.contains(currentPoint)) {
                    pathToFromBoth.add(currentPoint)
                }
            }
        }
        return pathToFromBoth.map { listOf(it.first,it.second) }

    }

    private fun dfs(visited: MutableSet<Pair<Int,Int>>, currentPoint: Pair<Int, Int>, matrix: Array<IntArray>, height: Int)  {
        if (currentPoint.first < 0 || currentPoint.second < 0 || currentPoint.first >= matrix.size || currentPoint.second >= matrix[0].size || matrix[currentPoint.first][currentPoint.second] < height)
        {
            return
        }
        visited.add(currentPoint)
        listOf(
                Pair(currentPoint.first+1,currentPoint.second),
                Pair(currentPoint.first-1,currentPoint.second),
                Pair(currentPoint.first,currentPoint.second+1),
                Pair(currentPoint.first,currentPoint.second-1)
        )
                .filter { !visited.contains(it) }
                .forEach { dfs(visited,it,matrix,matrix[currentPoint.first][currentPoint.second]) }
    }

}