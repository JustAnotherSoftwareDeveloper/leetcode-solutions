import kotlin.math.abs

/**
 * https://www.hackerrank.com/challenges/sherlock-and-cost/problem
 */
class SherlockAndCost {

    fun cost(B: Array<Int>): Int {

        var low = 0;
        var high = 0
        for (i in 1 until B.size) {
            val highToLowDiff = abs(B[i-1]-1);
            val lowToHighDiff = abs(B[i]-1)
            val highToHighDiff = abs(B[i]-B[i-1])

            val nextLow = maxOf(low,high+highToLowDiff)
            val nextHigh = maxOf(high+highToHighDiff,low+lowToHighDiff)
            low = nextLow
            high = nextHigh
        }

        return maxOf(high,low)
    }
}