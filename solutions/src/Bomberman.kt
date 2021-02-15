/**
 * https://www.hackerrank.com/challenges/bomber-man/problem
 */
class Bomberman {

    fun bomberMan(n: Int, grid: Array<String>) : Array<String> {
        val bombPlacements = mutableMapOf<Int,MutableSet<Pair<Int,Int>>>();
        bombPlacements[0] = mutableSetOf()
        bombPlacements[1] = mutableSetOf()
        bombPlacements[2] = mutableSetOf()
        bombPlacements[3] = mutableSetOf()

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == '.') {
                    //No Bomb
                    bombPlacements[0]!!.add(Pair(i,j))
                }
                else {
                    //Bomb
                    bombPlacements[3]!!.add(Pair(i,j))
                }
            }
        }

        for (i in 1..n) {
            if (i % 2 == 0) {
                bombPlacements[0]!!.forEach { bombPlacements[3]!!.add(it) }
                bombPlacements[0] = mutableSetOf()
            }
            //1s -> 0s. Explode
            val possibleExplosions = bombPlacements[1]!!
                    .map { setOf(Pair(it.first,it.second),Pair(it.first+1,it.second),Pair(it.first-1,it.second), Pair(it.first,it.second+1),Pair(it.first,it.second-1)) }
            val removedSpaces: Set<Pair<Int,Int>> = if (possibleExplosions.isEmpty()) mutableSetOf() else possibleExplosions.reduce { acc, set -> set+acc}
                    .filter { it.first >= 0 && it.first < grid.size && it.second >= 0 && it.second < grid[0].length }.toSet()

            bombPlacements[1]!!.removeAll(removedSpaces)
            bombPlacements[2]!!.removeAll(removedSpaces)
            bombPlacements[3]!!.removeAll(removedSpaces)
            bombPlacements[0]!!.addAll(removedSpaces)
            // 2s - 1s
            bombPlacements[1] = bombPlacements[2]!!
            // 3s - 2s
            bombPlacements[2] = bombPlacements[3]!!
            //Nothing at 3s
            bombPlacements[3] = mutableSetOf()
        }

        val newGrid = Array(grid.size){CharArray(grid[0].length){'O'} }
        bombPlacements[0]!!.forEach { newGrid[it.first][it.second] = '.' }

        return newGrid.map { it.joinToString("") }.toTypedArray()
    }
}