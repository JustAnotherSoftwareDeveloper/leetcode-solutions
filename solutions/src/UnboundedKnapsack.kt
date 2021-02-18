/**
 * https://www.hackerrank.com/challenges/unbounded-knapsack/problem
 */
class UnboundedKnapsack {

    // Complete the unboundedKnapsack function below.
    fun unboundedKnapsack(k: Int, arr: Array<Int>): Int {

        val uniqueElements = arr.toSet().toList();
        val dpArray =  BooleanArray(k+1)
        dpArray[0] = true

        for (i in 0..k) {
            for (element in uniqueElements) {
                if (i+element <= k) {
                    dpArray[i+element] = dpArray[i+element] || dpArray[i];
                }
            }
        }

        var max = 0;
        for (i in dpArray.indices) {
            if (dpArray[i]) {
                max = i
            }
        }

        return max

    }



}