import java.math.BigInteger

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified/problem
 */
class ModifiedFibonacci {

    fun fibonacciModified(t1: Int, t2: Int, n: Int): BigInteger {

        val dpFib = Array(n){BigInteger.ONE}
        dpFib[0] = BigInteger(t1.toString())
        dpFib[1] = BigInteger(t2.toString())
        for (i in 3 until n) {
            dpFib[i] = dpFib[i-1].times(dpFib[i-1]) + dpFib[i-2]
        }

        return dpFib.last()

    }
}