/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/
 */
class RevealCardsInIncreasingOrder {
    fun deckRevealedIncreasing(deck: IntArray) : IntArray {
        val queue = deck.mapIndexed { index, i -> index }.toMutableList()
        val deckSorted = deck.sorted()
        val returnList = IntArray(deck.size)
        for (i in deckSorted.indices) {
            val current = queue.removeAt(0)
            returnList[current] = deckSorted[i]
            if (queue.isNotEmpty()) {
                queue.add(queue.removeAt(0))
            }
        }
        return returnList

    }
}