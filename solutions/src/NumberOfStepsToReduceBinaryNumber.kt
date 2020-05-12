import java.math.BigInteger

/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 */
class NumberOfStepsToReduceBinaryNumber {
    fun numSteps(s: String) : Int {
        var number = BigInteger(s,2)
        var numSteps = 0;
        while (number != BigInteger.ONE) {
            number = if (number.mod(BigInteger("2")) == BigInteger.ZERO) {
                number.divide(BigInteger("2"))
            } else {
                number.plus(BigInteger.ONE)
            }
            numSteps++
        }

        return numSteps
    }
}