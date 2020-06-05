/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths
 */
class MaxWordLengthProducts {
    fun maxProduct(words: Array<String>) :Int {
        var maxProductAmount = 0
        val wordsInStrLenPairs = words.map { Pair(it.length,it.toSet()) }
        for (i in wordsInStrLenPairs.indices) {
            for (j in wordsInStrLenPairs.indices) {
                if (i != j && !wordsInStrLenPairs[i].second.any { wordsInStrLenPairs[j].second.contains(it) }) {
                    maxProductAmount = maxOf(maxProductAmount,wordsInStrLenPairs[i].first*wordsInStrLenPairs[j].first)
                }
            }
        }
        return maxProductAmount
    }


}