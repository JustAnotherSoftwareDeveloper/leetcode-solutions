/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 */
class LongestPalindromicSubsequence {

    fun longestPalindromeSubseq(s: String) : Int {
        val dp = Array(s.length) {IntArray(s.length)}
        for(i in dp.indices) {
            dp[i][i] = 1
        }
        for(i in dp.lastIndex downTo 0) {
            for(j in i+1 until dp.size) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i+1][j-1]+2
                }
                else {
                    dp[i][j] = maxOf(dp[i+1][j],dp[i][j-1])
                }
            }
        }
        return dp[0][dp.lastIndex]
    }
}