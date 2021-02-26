/**
 * https://leetcode.com/problems/where-will-the-ball-fall/
 */
class WhereWillTheBallFall {

    fun findBall(grid: Array<IntArray>) : IntArray {

        val numBalls = grid[0].size
        val ballPositions = mutableMapOf<Int,Int>()
        val badPositions = mutableSetOf<Pair<Int,Int>>()
        for (i in 0 until numBalls) {
            ballPositions[i] = i
        }
        for (i in grid.indices) {
            for (j in 0 until grid[0].lastIndex) {
                if ((grid[i][j] == 1 && grid[i][j+1] == -1)) {
                    badPositions.add(Pair(i,j))
                    badPositions.add(Pair(i,j+1))
                }
            }
        }

        for (i in grid[0].indices) {
            if (badPositions.contains(Pair(0,i))) {
                ballPositions[i] = -1
            }
        }

        for (i in grid.indices) {
            for (ball in ballPositions.keys) {
                val currentPosition = ballPositions[ball]!!
                if (currentPosition != -1) {
                    val newPosition = if (grid[i][currentPosition] == 1) currentPosition+1 else currentPosition-1
                    if (badPositions.contains(Pair(i+1,newPosition))) {
                        ballPositions[ball] = -1
                    }
                    else if (newPosition < 0 || newPosition >= grid[0].size) {
                        ballPositions[ball] = -1
                    }
                    else {
                        ballPositions[ball] = newPosition
                    }
                }
            }
        }

        val returnPositions = mutableListOf<Int>()
        for (i in grid[0].indices) {
            returnPositions.add(ballPositions[i]!!)
        }
        return returnPositions.toIntArray()
    }
}