/**
 * https://leetcode.com/problems/longest-common-subsequence/
 */
class LongestCommonSubequence {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val dp = Array(text1.length+1) {IntArray(text2.length+1)}
        for(i in text1.indices) {
            for (j in text2.indices) {
                if (text1[i] == text2[j]) {
                    dp[i+1][j+1] = dp[i][j] +1
                }
                else {
                    dp[i+1][j+1] = maxOf(dp[i][j+1],dp[i+1][j])
                }

            }
        }
        return dp[text1.length][text2.length]

    }
}