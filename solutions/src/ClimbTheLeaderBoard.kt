import java.util.*

/**
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 */
class ClimbTheLeaderBoard {
    // Complete the climbingLeaderboard function below.
    fun climbingLeaderboard(scores: Array<Int>, alice: Array<Int>): Array<Int> {
        if (scores.isEmpty()) {
            return alice.map { 1 }.toTypedArray()
        }
        val ranks = mutableListOf<Int>()
        val existingScoreMap = TreeMap<Int,Int>()
        var currRank = 1
        scores.sortedArrayDescending().forEach {
            if (!existingScoreMap.containsKey(it)) {
                existingScoreMap[it] = currRank
                currRank++
            }
        }
        val maxRank = 1
        val lastRank = existingScoreMap.firstEntry().value
        alice.forEach {
            if (existingScoreMap.containsKey(it)) {
                ranks.add(existingScoreMap[it]!!)
            }
            else {
                val headEntry= existingScoreMap.higherEntry(it)
                if (headEntry == null) {
                    ranks.add(1);
                }
                else {
                    val newRank = headEntry.value+1
                    ranks.add(newRank)
                }

            }
        }

        return ranks.toTypedArray()
    }

}