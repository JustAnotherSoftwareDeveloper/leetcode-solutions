/**
 * https://www.hackerrank.com/challenges/common-child/problem
 */
class CommonStringChild {

    // Complete the commonChild function below.
    fun commonChild(s1: String, s2: String): Int {
        val dpArray = Array(s1.length+1){IntArray(s2.length+1)}

        for (i in 1..s1.length) {
            for (j in 1..s2.length) {
                if (s1[i-1] == s2[j-1]) {
                    dpArray[i][j] = dpArray[i-1][j-1]+1
                }
                else {
                    dpArray[i][j] = maxOf(dpArray[i-1][j],dpArray[i][j-1])
                }
            }
        }
        return dpArray[s1.length][s2.length]
    }
}