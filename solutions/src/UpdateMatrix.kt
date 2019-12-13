class UpdateMatrix{
    fun updateMatrix(matrix: Array<IntArray>) : Array<IntArray> {
        val mappedValues = mutableMapOf<Pair<Int,Int>,Int>()
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 0) {
                    mappedValues[Pair(i,j)] = 0
                }
            }
        }
        val queue = mappedValues.keys.toMutableList()
        while (queue.isNotEmpty()) {
            val currentPair = queue.removeAt(0)
            val possiblePairs = mutableListOf<Pair<Int,Int>>()
            //Down
            if (currentPair.first > 0) {
                possiblePairs.add(Pair(currentPair.first-1,currentPair.second))
            }
            //UP
            if (currentPair.first < matrix.lastIndex) {
                possiblePairs.add(Pair(currentPair.first+1,currentPair.second))
            }
            //Left
            if (currentPair.second > 0) {
                possiblePairs.add(Pair(currentPair.first,currentPair.second-1))
            }
            //Right
            if (currentPair.second < matrix[0].lastIndex) {
                possiblePairs.add(Pair(currentPair.first,currentPair.second+1))
            }
            possiblePairs.filter { !mappedValues.containsKey(it) }.forEach{
                queue.add(it)
                mappedValues[it] = mappedValues[currentPair]!!+1
            }
        }
        val returnList = mutableListOf<MutableList<Int>>()
        for( i in matrix.indices) {
            returnList.add(mutableListOf())
            for(j in matrix[0].indices) {
                returnList[i].add(mappedValues[Pair(i,j)]!!)
            }
        }
        return returnList.map { it.toIntArray() }.toTypedArray()
    }
}