import java.util.*

/**
 * https://leetcode.com/problems/hand-of-straights
 */
class HandOfStraights {
    fun isNStraightHand(hand: IntArray, W: Int): Boolean {

        if (hand.size % W != 0) {
            return false
        }

        val handByFreq = hand.toList().groupingBy { it }.eachCount()
        val handByFreqTree = TreeMap(handByFreq)

        while (handByFreqTree.isNotEmpty()) {
            val start = handByFreqTree.firstKey()
            if (handByFreqTree[start] == 1) {
                handByFreqTree.remove(start)
            }
            else {
                handByFreqTree[start] = handByFreqTree[start]!!-1
            }
            var currSize = 1
            var lastCard = start
            while (currSize < W) {
                val nextCard = lastCard+1
                if (handByFreqTree[nextCard] == null) {
                    return false
                }
                else if (handByFreqTree[nextCard] == 1) {
                    handByFreqTree.remove(nextCard)
                }
                else {
                    handByFreqTree[nextCard] = handByFreqTree[nextCard]!!-1
                }
                currSize++
                lastCard = nextCard
            }
        }
        return true
    }
}