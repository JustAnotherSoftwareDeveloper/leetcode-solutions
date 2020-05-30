import kotlin.test.currentStackTrace

/**
 * https://leetcode.com/problems/k-concatenation-maximum-sum/
 */
class MaximumSubArraySum {
    fun kConcatenationMaxSum(arr: IntArray, k: Int): Int {
        val MOD = 1000000007
        if (arr.none { it < 0 }) {
            return ((arr.sum()*k.toLong()) % MOD).toInt()
        }
        if (arr.none{ it > 0}) {
            return 0
        }
        val sumsFromAsc = LongArray(arr.size)
        sumsFromAsc[0] = arr[0].toLong()
        for (i in 1 until arr.size) {
            sumsFromAsc[i] = arr[i]+sumsFromAsc[i-1]
        }
        val sumsFromDesc = LongArray(arr.size)
        sumsFromDesc[arr.lastIndex] = arr[arr.lastIndex].toLong()
        for( i in arr.lastIndex-1 downTo 0) {
            sumsFromDesc[i] = arr[i]+sumsFromDesc[i+1]
        }
        var ascMaxSum = Pair(0L,-1)
        var descMaxSum = Pair(0L,-1);
        for (i in arr.indices) {
            if (ascMaxSum.first <= sumsFromAsc[i]) {
                ascMaxSum = Pair(sumsFromAsc[i],i)
            }
            if (descMaxSum.first <= sumsFromDesc[i]) {
                descMaxSum = Pair(sumsFromDesc[i],i)
            }
        }
        val maxSubArray = maxSum(arr)
        val arraySum = arr.map { it.toLong() }.sum()
        when {
            k == 1 -> {
                return (maxSubArray % MOD).toInt()
            }
            arraySum > 0 -> {
                var sum = (arraySum*(k-2));
                if (descMaxSum.second >= 0) {
                    sum+= descMaxSum.first
                }
                if (ascMaxSum.second >= 0) {
                    sum+= ascMaxSum.first
                }
                return (sum % MOD).toInt()
            }
            else -> {
                return (maxOf(maxSubArray,ascMaxSum.first+descMaxSum.first) % MOD).toInt()
            }
        }

    }

    private fun maxSum(A: IntArray) : Long {
        var curMax = 0L
        var maxEncountered = 0L
        A.forEach {
            if (curMax < 0) {
                curMax = it.toLong()
            }
            else {
                curMax+=it
            }
            maxEncountered = maxOf(maxEncountered,curMax)
        }
        return maxEncountered
    }
}