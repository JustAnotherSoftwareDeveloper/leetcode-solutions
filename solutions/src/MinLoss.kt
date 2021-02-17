import java.util.*
import kotlin.math.abs

/**
 * https://www.hackerrank.com/challenges/minimum-loss/problem
 */
class MinLoss {

    fun minimumLoss(price: Array<Long>) : Int {

        val numbersIndexMap = mutableMapOf<Long,Int>()
        price.forEachIndexed { index, l -> numbersIndexMap[l] = index }

        var minLoss = Int.MAX_VALUE
        val sortedPrices = price.sorted()
        for (i in 0 until sortedPrices.lastIndex) {
            val loss = sortedPrices[i+1]-sortedPrices[i]
            val validTrade = numbersIndexMap[sortedPrices[i]]!! > numbersIndexMap[sortedPrices[i+1]]!!
            if (validTrade) {
                minLoss = minOf(minLoss,loss.toInt())
            }
        }



        return minLoss
    }
}