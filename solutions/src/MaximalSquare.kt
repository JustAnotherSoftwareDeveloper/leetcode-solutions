class MaximalSquare {
    /*
    This was my solution. It is (m*n)^2. However, the correct solution is m*n.
    I have noted that for my studies and am leaving this up as a record.
     */
    fun maximalSquare(matrix: Array<CharArray>): Int {
        var largest = 0
        for(i in matrix.indices) {
            for(j in matrix[0].indices) {
                largest = maxOf(largest,maxSquareAt(Pair(i,j),matrix))
            }
        }
        return largest
    }

    fun maxSquareAt(coordinates: Pair<Int,Int>, matrix: Array<CharArray>) : Int {

        var largestSquare = 0
        var new = mutableSetOf(coordinates)
        val validRange = {pair:Pair<Int,Int> -> pair.first <= matrix.lastIndex && pair.first >= 0 && pair.second <= matrix[0].lastIndex && pair.second >= 0 }
        while (new.all{ validRange(it) && matrix[it.first][it.second] == '1' }) {
            largestSquare++
            var nextLevel = mutableSetOf<Pair<Int,Int>>()
            new.forEach {
                val right = Pair(it.first+1,it.second)
                val down = Pair(it.first,it.second-1)
                val diag = Pair(it.first+1,it.second-1)
                nextLevel.addAll(listOf(right,down,diag))
            }
            new = nextLevel
        }
        return largestSquare*largestSquare
    }
}