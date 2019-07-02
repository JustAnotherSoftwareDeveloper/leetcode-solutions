//https://leetcode.com/problems/number-of-islands/submissions/
class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>) : Int {
        var islands = 0

        val gridMap : MutableMap<Pair<Int,Int>, GridSpace> = mutableMapOf()
        for (i in 0 until grid.size) {
            val innerGrid = grid[i]
            for (j in 0 until innerGrid.size) {
                val space = GridSpace(grid[i][j] == '1', false, i, j)
                gridMap[Pair(i,j)] = space
            }
        }
        gridMap.values.forEach {
            if (!it.touched && it.isIsland) {
                islands++
                scanLandMass(it,gridMap)
            }
        }
        return islands
    }

    private data class GridSpace(val isIsland: Boolean, var touched: Boolean, val x: Int, val y: Int)

    private fun scanLandMass(space: GridSpace, map: Map<Pair<Int,Int>,GridSpace>) : Unit {
        space.touched = true
        val spaces = mutableListOf<GridSpace?>()
        spaces.add(map[Pair(space.x,space.y+1)])
        spaces.add( map[Pair(space.x, space.y -1)])
        spaces.add(map[Pair(space.x-1, space.y)])
        spaces.add( map[Pair(space.x+1,space.y)])

        spaces.filter { it != null && !it.touched && it.isIsland  }.forEach { scanLandMass(it!!,map) }
    }
}