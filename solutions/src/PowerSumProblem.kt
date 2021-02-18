/**
 * https://www.hackerrank.com/challenges/the-power-sum/problem
 */
class PowerSumProblem {

    // Complete the powerSum function below.
    fun powerSum(X: Int, N: Int): Int {

        return findPowerSum(X,N,1)

    }

    private fun findPowerSum(total: Int, power: Int, number: Int) : Int {

        val value = total-Math.pow(number.toDouble(),power.toDouble()).toInt()

        return when {
            value < 0 -> {
                0;
            }
            value == 0 -> {
                1
            }
            else -> {
                findPowerSum(value,power,number+1) + findPowerSum(total,power,number+1)
            }
        }
    }
}