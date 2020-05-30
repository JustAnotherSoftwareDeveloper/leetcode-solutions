import kotlin.math.max

/**
 * https://leetcode.com/problems/predict-the-winner/
 */
class PredictTheWinner {

    fun PredictTheWinner(nums: IntArray) : Boolean {
        val n: Int = nums.size
        val dp = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            dp[i][i] = nums[i]
        }
        for (len in 1 until n) {
            for (i in 0 until n - len) {
                val j = i + len
                dp[i][j] = maxOf(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1])
            }
        }
        return dp[0][n - 1] >= 0
    }
}