/**
 * https://www.hackerrank.com/challenges/count-luck/problem
 */
class CountLuck {

    // Complete the countLuck function below.
    fun countLuck(matrix: Array<String>, k: Int): String {

        return if (determineStepDirectionSwitches(matrix, k)) "Impressed" else "Oops!"

    }


    private fun determineStepDirectionSwitches(matrix: Array<String>, k: Int) : Boolean {
        val m = matrix.size
        val n = matrix[0].length
        val queue = mutableListOf<Step>()
        val visited = mutableSetOf<Pair<Int,Int>>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 'M') {
                    queue.add(Step(Pair(i,j),0,DIRECTION.NONE))
                }
            }
        }

        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0)
            val currentCoordinates = current.coordinates
            //Check if at destination
            if (matrix[currentCoordinates.first][currentCoordinates.second] == '*') {
                return current.changes == k
            }
            //Add Coordinates to Visited
            visited.add(currentCoordinates)
            //UP
            val upStep = Step(
                    Pair(currentCoordinates.first-1,currentCoordinates.second),
                    current.changes,
                    DIRECTION.UP
            )
            //Down
            val downStep = Step(
                    Pair(currentCoordinates.first+1,currentCoordinates.second),
                    current.changes,
                    DIRECTION.DOWN
            )
            //Left
            val leftStep = Step(
                    Pair(currentCoordinates.first,currentCoordinates.second-1),
                    current.changes,
                    DIRECTION.LEFT
            )
            //Right
            val rightStep = Step(
                    Pair(currentCoordinates.first,currentCoordinates.second+1),
                    current.changes,
                    DIRECTION.RIGHT
            )

            var possibleSteps = listOf(
                    upStep,
                    downStep,
                    leftStep,
                    rightStep
            ).filter {
                val stepCoordinates = it.coordinates
                stepCoordinates.first >= 0 &&
                        stepCoordinates.second >= 0 &&
                        stepCoordinates.first < m &&
                        stepCoordinates.second < n &&
                        matrix[stepCoordinates.first][stepCoordinates.second] != 'X' &&
                        !visited.contains(stepCoordinates)
            }
            if (possibleSteps.size > 1) {
                possibleSteps = possibleSteps.map { it.copy(changes = it.changes+1) }
            }
            possibleSteps.forEach { queue.add(it) }
        }


        return false
    }

    private enum class DIRECTION {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        NONE
    }

    private data class Step(val coordinates: Pair<Int,Int>, val changes: Int,val direction: DIRECTION )
}