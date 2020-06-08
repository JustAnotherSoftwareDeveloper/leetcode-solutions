import java.util.*

/**
 * https://leetcode.com/problems/bag-of-tokens/
 */
class BagOfTokens {
    fun bagOfTokensScore(tokens: IntArray, P: Int): Int {
        val tokensSorted = tokens.sorted()
        var leftPointer = 0
        var rightPointer = tokensSorted.lastIndex
        var currPower = P
        var score = 0
        while (rightPointer >= leftPointer) {
            if (currPower >= tokensSorted[leftPointer]) {
                score++
                currPower-=tokensSorted[leftPointer]
                leftPointer++
            }
            else if (score > 0 && leftPointer != rightPointer) {
                currPower+=tokensSorted[rightPointer]
                score--
                rightPointer--
            }
            else {
                break
            }
        }

        return score


    }
}