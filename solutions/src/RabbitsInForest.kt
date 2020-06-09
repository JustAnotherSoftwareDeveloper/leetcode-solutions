import kotlin.math.ceil

/**
 * https://leetcode.com/problems/rabbits-in-forest/
 */
class RabbitsInForest {
    fun numRabbits(answers: IntArray): Int {
        val rabbitsPerOthers = answers.toList().groupingBy { it }.eachCount()
        return rabbitsPerOthers.map {
            (it.key+1) * ceil(it.value/(it.key+1).toDouble())
        }.sum().toInt()
    }
}