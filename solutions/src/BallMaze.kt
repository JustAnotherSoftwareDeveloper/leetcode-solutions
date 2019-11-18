
class BallMaze {

    fun shortestDistance(maze: Array<IntArray>, start: IntArray, destination: IntArray) : Int {
        return dfsMaze(maze, Pair(start[0],start[1]), Pair(destination[0],destination[1]),null, mutableSetOf()) ?: -1
    }

    private fun dfsMaze(maze: Array<IntArray>, start: Pair<Int,Int>, target: Pair<Int,Int>, direction: Direction?, visited: MutableSet<Pair<Int,Int>>) : Int? {
        val yAxis = maze.size
        val xAxis = maze[0].size
        visited.add(start);
        val possiblePaths = mutableListOf<Int?>();
        val nextStep = when (direction) {
            null -> null
            Direction.LEFT-> Pair(start.first,start.second-1)
            Direction.RIGHT -> Pair(start.first,start.second+1)
            Direction.DOWN -> Pair(start.first-1,start.second)
            Direction.UP -> Pair(start.first+1,start.second)
        }
        //hit a wall
        if (nextStep == null || nextStep.first < 0 || nextStep.first >= yAxis || nextStep.second < 0 || nextStep.second >= xAxis || maze[nextStep.first][nextStep.second] == 1 ) {
            if (start == target) {
                return 0;
            }
            if (start.first+1<yAxis && !visited.contains(Pair(start.first+1,start.second)) && maze[start.first+1][start.second]!=1) {
                possiblePaths.add(dfsMaze(maze, Pair(start.first+1,start.second),target,Direction.UP,visited.toMutableSet()))
            }
            if (start.first-1 >= 0 && !visited.contains(Pair(start.first-1,start.second))&& maze[start.first-1][start.second]!=1 ) {
                possiblePaths.add(dfsMaze(maze, Pair(start.first-1,start.second),target,Direction.DOWN,visited.toMutableSet()))
            }
            if (start.second+1<xAxis && !visited.contains(Pair(start.first,start.second+1)) && maze[start.first][start.second+1]!=1 ) {
                possiblePaths.add(dfsMaze(maze, Pair(start.first,start.second+1),target,Direction.RIGHT,visited.toMutableSet()));
            }
            if (start.second-1 >= 0 && !visited.contains(Pair(start.first,start.second-1)) && maze[start.first][start.second-1]!=1 ) {
                possiblePaths.add(dfsMaze(maze, Pair(start.first,start.second-1),target,Direction.LEFT,visited.toMutableSet()));
            }
        }
        else {
            if (!visited.contains(nextStep)) {
                possiblePaths.add(dfsMaze(maze,nextStep,target,direction,visited.toMutableSet()))
            }
        }
        val minPath = possiblePaths.filterNotNull().min()
        return if (minPath!=null) minPath+1 else null


    }

    private enum class Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}