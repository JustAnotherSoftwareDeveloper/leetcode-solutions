/**
 * https://leetcode.com/problems/champagne-tower/
 */
class ChampagneTower {

    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val dp = mutableListOf<MutableList<Double>>()
        for (i in 0..query_row) {
            dp.add(mutableListOf())
            for (j in 0..i) {
                dp[i].add(0.0)
            }
        }
        dp[0][0] = poured.toDouble()
        dp.forEachIndexed { index,row ->
            if (index != dp.lastIndex) {
                row.forEachIndexed { index2, amount ->
                    val newAmount : Double = if (amount > 1.0) {
                        (amount-1.0)/2.0
                    }
                    else  {
                        0.0
                    }
                    dp[index+1][index2]+=newAmount
                    dp[index+1][index2+1]+=newAmount
                }
            }

        }
        return minOf(dp[query_row][query_glass],1.0)

    }

}