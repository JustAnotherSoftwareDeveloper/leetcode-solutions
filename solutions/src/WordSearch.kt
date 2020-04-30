/**
 * https://leetcode.com/problems/word-search/
 */
class WordSearch {

    fun exist(board: Array<CharArray>, word: String) : Boolean {
        for(i in board.indices) {
            for (j in board[0].indices) {
                if (existsInSpace(board,word.toCharArray(),i,j, setOf())) {
                    return true
                }
            }
        }
        return false
    }



    private fun existsInSpace(board: Array<CharArray>, word: CharArray, i : Int, j : Int, visited: Set<Pair<Int,Int>>) : Boolean {

        if (i < 0 || i > board.lastIndex || j < 0 || j > board[0].lastIndex || visited.contains(Pair(i,j))) {
            return false
        }
        if (word.size == 1 && word[0] == board[i][j]) {
            return true
        }
        if (board[i][j] == word[0]) {
            val newVisited = visited+Pair(i,j);
            val newWord = word.toList().slice(1..word.lastIndex).toCharArray()
            return existsInSpace(board,newWord,i+1,j,newVisited) ||
                    existsInSpace(board,newWord,i-1,j,newVisited) ||
                    existsInSpace(board,newWord,i,j-1,newVisited) ||
                    existsInSpace(board,newWord,i,j+1, newVisited)
        }
        return false

    }
}