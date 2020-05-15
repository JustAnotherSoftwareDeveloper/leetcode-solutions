import java.util.*

/**
 * https://leetcode.com/problems/count-number-of-teams/
 *
 * my solution was accepted O(N^3), so I read up on a better solution and
 * pasted it here for verbosity.
 */
class CountNumberOfTeams {
    fun numTeams(rating: IntArray) : Int {

        var count = 0

        // initial loop through without the first nor nth position, j represents the middle number

        // initial loop through without the first nor nth position, j represents the middle number
        for (j in 1 until rating.size - 1) {
            var smaller = 0
            var larger = 0

            // counts all values from position 0 to j-1 that are smaller than rating[j]
            for (i in 0 until j) {
                if (rating[i] < rating[j]) {
                    smaller++
                }
            }

            // counts all values from position j+1 to n that are larger than rating[j]
            for (k in j + 1 until rating.size) {
                if (rating[k] > rating[j]) {
                    larger++
                }
            }

            // add the permutation of smaller before j * larger after j
            count += smaller * larger
            // add the permutation of larger before j * smaller after j
            count += (j - smaller) * (rating.size- (j + 1) - larger)
        }
        return count
    }

}