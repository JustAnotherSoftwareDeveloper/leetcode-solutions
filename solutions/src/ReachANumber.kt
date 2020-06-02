import kotlin.math.abs

/**
 * https://leetcode.com/problems/reach-a-number/
 */
class ReachANumber {
    fun reachNumber(target: Int) : Int {
        val t = abs(target)
        var step = 0
        var sum = 0
        while (sum < t) {
            step++
            sum += step
        }
        while ((sum - t) % 2 !== 0) {
            step++
            sum += step
        }

        return step

    }

}