class BattleShipsInABoard {

    fun countBattleships(board: Array<CharArray>) : Int {
        var totalBattleShips = 0;

        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == 'X') {
                    totalBattleShips++;
                    board[i][j] = '.'
                    var newI = i+1;
                    while (newI < board.size && board[newI][j] == 'X') {
                        board[newI][j] = '.';
                        newI++;
                    }
                    newI = i-1;
                    while (newI >= 0 && board[newI][j] == 'X') {
                        board[newI][j] = '.';
                        newI--;
                    }
                    var newJ = j+1;
                    while (newJ < board[0].size && board[i][newJ] == 'X') {
                        board[i][newJ] = '.';
                        newJ++;
                    }
                    newJ = j - 1;
                    while (newJ >= 0 && board[i][newJ] == 'X') {
                        board[i][newJ] = '.';
                        newJ--;
                    }
                }
            }
        }

        return totalBattleShips;
    }
}