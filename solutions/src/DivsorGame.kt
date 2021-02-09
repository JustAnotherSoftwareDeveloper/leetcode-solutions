/**
 * https://leetcode.com/problems/divisor-game/
 */
class DivsorGame {

    fun divisorGame(N: Int): Boolean {
        val dp = BooleanArray(N + 1)
        dp[0] = false
        dp[1] = false
        for (i in 2..N) {
            for (j in 1 until i) {
                if (i % j == 0) {
                    if (!dp[i - j]) {
                        dp[i] = true
                        break
                    }
                }
            }
        }
        return dp[N]
    }
}