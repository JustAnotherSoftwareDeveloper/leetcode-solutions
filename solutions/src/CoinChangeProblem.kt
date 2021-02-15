/**
 * https://www.hackerrank.com/challenges/coin-change/problem
 */
class CoinChangeProblem {

    fun getWays(n: Int, c: Array<Long>): Long {
        val cInts = c.map { it.toInt() }
        var dpArray = LongArray(n+1)

        dpArray[0] = 1

        for (i in c.indices) {
            for (j in 0..n) {
                if (c[i] <= j) {
                    dpArray[j]+= dpArray[(j-c[i]).toInt()]
                }
            }
        }

        return dpArray[n]
    }
}