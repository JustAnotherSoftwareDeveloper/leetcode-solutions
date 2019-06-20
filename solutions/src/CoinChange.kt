//https://leetcode.com/problems/coin-change/
class CoinChange {

    fun coinChange(coins: IntArray, amount: Int): Int {
        val dynamicCoins = arrayOfNulls<Int>(amount+1)
        dynamicCoins.fill(amount+1)
        dynamicCoins[0] = 0
        for ( i in 1..amount) {
            for (j in 0 until coins.size) {
                if (coins[j] <= i) {
                    dynamicCoins[i] = Math.min(dynamicCoins[i]!!, dynamicCoins[i - coins[j]]!! + 1)
                }
            }
        }
        return if (dynamicCoins[amount]!! > amount) -1 else dynamicCoins[amount]!!


    }


}