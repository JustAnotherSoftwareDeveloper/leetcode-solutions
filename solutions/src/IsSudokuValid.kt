class IsSudokuValid {
    fun isValidSudoku(board: Array<CharArray>) : Boolean {
        val cellRows = mutableMapOf<Pair<Int,Int>,MutableList<Char>>()
        val rowRows = mutableListOf<MutableList<Char>>()
        val columnRows = mutableListOf<MutableList<Char>>()
        val acceptedChars = setOf('1','2','3','4','5','6','7','8','9')
        for (i in 0 until 9) {
            rowRows.add(mutableListOf())
            columnRows.add(mutableListOf())
        }
        for (i in 0 until 3) {
            for(j in 0 until 3) {
                cellRows[Pair(i,j)] = mutableListOf()
            }
        }
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == '.') {
                    continue
                }
                else if (!acceptedChars.contains(board[i][j])) {
                    return false
                }
                else {
                    rowRows[i].add(board[i][j])
                    columnRows[j].add(board[i][j])

                    cellRows[Pair(i /3,j /3)]!!.add(board[i][j])
                }
            }
        }

        val allRows = cellRows.values+rowRows+columnRows
        return allRows.map {
            val setEquiv = it.toSet()
            it.size == setEquiv.size
        }.all { it }

        
    }
}