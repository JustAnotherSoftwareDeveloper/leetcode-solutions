import java.util.stream.LongStream
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

class NthMagicalNumber {
   // https://leetcode.com/problems/nth-magical-number/description/
    fun nthMagicalNumber(N: Int, A:Int, B:Int ): Int {
        val mod: Int = 1000000007
        val lcm = leastCommonMultiple(A,B)
        var lowestPossible = 0.toLong()
        var highestPossible = N.toLong() * max(A,B)
        while (lowestPossible < highestPossible) {
            val middle = (lowestPossible+highestPossible)/2
            val magicAtMiddle = middle / A + middle / B - middle /lcm
            if (magicAtMiddle < N) {
                lowestPossible = middle+1
            }
            else {
                highestPossible = middle
            }
        }
        return (lowestPossible % mod).toInt()

    }

    fun greatestCommonDenominator(a: Int, b: Int) : Int{
        if (a == 0) {
            return b
        }
        return greatestCommonDenominator(b% a, a)
    }

    fun leastCommonMultiple(a: Int, b: Int): Long {
        return a.toLong() * b.toLong() / greatestCommonDenominator(a,b)
    }
}