
import java.util.Arrays

/**
 * https://leetcode.com/problems/stone-game-ii/
 */

class StoneGameII {

    fun stoneGameII(piles: IntArray): Int {
        val presum = piles.copyOf(piles.size)
        for (i in presum.size - 2 downTo 0) presum[i] += presum[i + 1]
        return dfs(presum, 1, 0, Array(piles.size) { IntArray(piles.size) })
    }

    private fun dfs(presum: IntArray, m: Int, p: Int, memo: Array<IntArray>): Int {
        if (p + 2 * m >= presum.size) { // last player takes all
            return presum[p]
        }
        if (memo[p][m] > 0) return memo[p][m]
        var res = 0
        var take = 0
        for (i in 1..2 * m) {
            // current take
            take = presum[p] - presum[p + i]
            // take max of current + what lefts from other player max take
            res = Math.max(res, take + presum[p + i] - dfs(presum, Math.max(i, m), p + i, memo))
        }
        memo[p][m] = res
        return res
    }
}