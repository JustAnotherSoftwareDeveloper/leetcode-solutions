import java.util.*

class MergeStones {
    fun mergeStones(stones: IntArray, K: Int): Int {
        val n = stones.size
        if ((n - 1) % (K - 1) > 0) return -1

        val prefix = IntArray(n + 1)
        for (i in 0 until n)
            prefix[i + 1] = prefix[i] + stones[i]

        val dp = Array(n) { IntArray(n) }
        for (m in K..n) {
            var i = 0
            while (i + m <= n) {
                val j = i + m - 1
                dp[i][j] = Integer.MAX_VALUE
                var mid = i
                while (mid < j) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j])
                    mid += K - 1
                }
                if ((j - i) % (K - 1) == 0)
                    dp[i][j] += prefix[j + 1] - prefix[i]
                ++i
            }
        }
        return dp[0][n - 1]
    }
}