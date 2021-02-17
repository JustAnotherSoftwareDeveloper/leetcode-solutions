/**
 * https://www.hackerrank.com/challenges/pairs/problem
 */
class MatchingPairs {


    // Complete the pairs function below.
    fun pairs(k: Int, arr: Array<Int>): Int {
        val numFrequency = arr.groupingBy { it }.eachCount()
        var totalPairs = 0
        if (k == 0) {
            return numFrequency.values.map { it/2 }.sum()
        }
        for (i in arr.indices) {
            val currentNum = arr[i];
            val upDifference = currentNum+k
            totalPairs+=numFrequency.getOrDefault(upDifference,0)
        }

        return totalPairs
    }
}