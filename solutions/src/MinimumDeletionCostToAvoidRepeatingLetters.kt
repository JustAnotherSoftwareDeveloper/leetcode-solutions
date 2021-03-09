/**
 * https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 */
class MinimumDeletionCostToAvoidRepeatingLetters {

    fun minCost(s: String, cost: IntArray): Int {
        if (s.length < 2) {
            return 0
        }
        var totalCost = 0
        var i = 0
        var j = 1
        while (j < s.length) {
            if (s[i] == s[j]) {
                if (cost[j] > cost[i]) {
                    totalCost+=cost[i]
                    i = j
                    j ++
                }
                else {
                    totalCost+=cost[j]
                    j++
                }
            }
            else {
                i = j
                j++
            }
        }
        return totalCost
    }

}