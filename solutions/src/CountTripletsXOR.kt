/**
 * https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
 * Just read the solution. Bitwise always gets me
 */
class CountTripletsXOR {
    fun countTriplets(A: IntArray): Int {
        val n = A.size + 1
        var res = 0
        val prefix = IntArray(n)
        for (i in 1 until n) prefix[i] = A[i - 1] xor prefix[i - 1]
        for (i in 0 until n) for (j in i + 1 until n) if (prefix[i] == prefix[j]) res += j - i - 1
        return res
    }
}