import kotlin.math.max

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class BuyingSellingStock {
    fun maxProfit(prices: IntArray) : Int {
        if (prices.size <= 1) {
            return 0
        }
        var maxProfit = 0
        var min = prices[0]
        prices.forEach {
            if (min > it) {
                min = it
            }
            else {
                maxProfit = max(maxProfit, it-min)
            }
        }
        return maxProfit
    }
}