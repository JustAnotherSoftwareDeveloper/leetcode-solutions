class KnightDialer {
    /**
     * https://leetcode.com/problems/knight-dialer/
     */
    fun knightDialer(n: Int) : Int {
        val MOD = 1000000007
        val dialerDP = Array(n){LongArray(12) { 0 } }
        for (i in 0..11) {
            if (i != 9 && i != 11) {
                dialerDP[0][i] = 1;
            }

        }
        for (i in dialerDP.indices) {
            if (i != dialerDP.lastIndex) {
                for (j in dialerDP[0].indices) {
                    if (j != 9 && j != 11) {
                        val possibleMoves = calculateIndicies(j);
                        possibleMoves.forEach {
                            dialerDP[i+1][it] = (dialerDP[i+1][it]+dialerDP[i][j]) % MOD
                        }
                    }
                }
            }

        }

        return (dialerDP.last().sum() % MOD).toInt();
    }

    private fun calculateIndicies(currentIndex: Int) : List<Int> {
        var iIndex = currentIndex/3;
        var jIndex = currentIndex % 3;
        return listOf(
                Pair(iIndex-2,jIndex-1),
                Pair(iIndex-2,jIndex+1),
                Pair(iIndex+2,jIndex-1),
                Pair(iIndex+2,jIndex+1),
                Pair(iIndex+1,jIndex-2),
                Pair(iIndex+1,jIndex+2),
                Pair(iIndex-1,jIndex-2),
                Pair(iIndex-1,jIndex+2)
        ).filter {
            it.second >= 0 && it.first >= 0 && it.second < 3 && it.first < 4 && it != Pair(3,0) && it != Pair(3,2)
        }.map {
            it.first*3 + it.second
        }
    }
}