class CoinChangeTwo {
    fun change(amount: Int, coins: IntArray): Int {
        var dp = IntArray(amount+1)
        dp[0] = 1
        coins.forEach {
            for (i in it..amount) {
                dp[i] += dp[i-it]
            }
        }
        return dp[amount]

    }
}