class MaxScoreFromRemovingStones {

    fun maximumScore(a: Int, b: Int, c: Int) : Int {
        var piles = mutableListOf(a,b,c)

        var moves = 0
        while (piles.filter { it >0 }.size >=2) {
            moves++
            val sortedPiles = piles.sortedDescending().toMutableList()
            sortedPiles[0] = sortedPiles[0]-1
            sortedPiles[1] = sortedPiles[1]-1
            piles = sortedPiles
        }
        return moves
    }
}