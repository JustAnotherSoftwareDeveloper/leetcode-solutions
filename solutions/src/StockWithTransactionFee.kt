class StockWithTransactionFee {
    fun maxProfit(prices: IntArray, fee: Int) : Int {
        println("fee: $fee ,prices: ${prices.contentToString()}")
        if (prices.size < 2) {
            return 0
        }
        var maxTradeValue = 0
        var minimum = prices[0]
        for (i in 1 until prices.size) {
            if (prices[i] < minimum) {
                minimum = prices[i]
            } else if (prices[i] > (minimum + fee)) {
                maxTradeValue += (prices[i] - (minimum + fee))
                minimum = prices[i] - fee
            }
        }

        return maxTradeValue

    }

}