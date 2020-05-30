/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */
class NumberOfDiceRollsWithTargetSum {
    fun numRollsToTarget(d: Int, f: Int, target: Int): Int {
        val MOD = 1000000007
        val dp = Array(d + 1) { IntArray(target + 1) }
        dp[0][0] = 1
        //how many possibility can i dices sum up to j;
        //how many possibility can i dices sum up to j;
        for (i in 1..d) {
            for (j in 1..target) {
                if (j > i * f) {
                    continue  //If j is larger than largest possible sum of i dices, there is no possible ways.
                } else {                      //watch out below condition, or NPE
                    var k = 1
                    while (k <= f && k <= j) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD
                        k++
                    }
                }
            }
        }
        return dp[d][target]

    }
}