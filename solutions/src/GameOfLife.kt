class GameOfLife {
    fun gameOfLife(board: Array<IntArray>) : Unit {
        if (board.isEmpty()) {
            return;
        }
        if (board[0].isEmpty()) {
            return
        }
        val height = board.size
        val spaceSet = mutableSetOf<Pair<Int,Int>>()
        val spaceMap = mutableMapOf<Pair<Int,Int>, Int>()
        for (i in board.indices) {
            for (j in board[0].indices) {
                spaceSet.add(Pair(i,j))
                spaceMap[Pair(i,j)] = board[i][j]
            }
        }
        val visited = mutableSetOf(Pair(0,0))
        val queue = mutableListOf(Pair(0,0))
        while(queue.isNotEmpty()) {
            var currentSpace = queue.removeAt(0)
            //Calc Space
            val spaces = getAdjacentSpaces(currentSpace,spaceSet)
            val numNeighbors = spaces.map { spaceMap[it]!! }.sum()

            val newVal = when {
                numNeighbors < 2 -> 0
                numNeighbors > 3 -> 0
                numNeighbors == 3 && board[currentSpace.first][currentSpace.second] == 0 -> 1
                (numNeighbors == 2 || numNeighbors == 3) && board[currentSpace.first][currentSpace.second] == 1 -> 1
                else -> 0
            }
            println("${currentSpace} -> $newVal")
            board[currentSpace.first][currentSpace.second] = newVal
            spaces.filter { !visited.contains(it) }.forEach {
                visited.add(it)
                queue.add(it)
            }

        }
    }

    fun getAdjacentSpaces(space: Pair<Int,Int>, spaceSet: Set<Pair<Int,Int>>) : List<Pair<Int,Int>> {
        val h = space.first
        val w = space.second
        return listOf(
                Pair(h+1,w),
                Pair(h-1,w),
                Pair(h,w+1),
                Pair(h,w-1),
                Pair(h+1,w+1),
                Pair(h-1,w+1),
                Pair(h-1,w-1),
                Pair(h+1,w-1)
        ).filter { spaceSet.contains(it) }
    }


}