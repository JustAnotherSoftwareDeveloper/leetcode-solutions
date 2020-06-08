/**
 * https://leetcode.com/problems/three-equal-parts/
 */
class ThreeEqualParts {
    fun threeEqualParts(A: IntArray): IntArray? {
        var numOne = 0
        for (i in A) {
            if (i == 1) numOne++
        }
        val noRes = intArrayOf(-1, -1)
        if (numOne == 0) return intArrayOf(0, 2)
        if (numOne % 3 != 0) return noRes

        //find index of starting 1 of third string
        var idxThird = 0
        var temp = 0
        for (i in A.indices.reversed()) {
            if (A[i] == 1) {
                temp++
                if (temp == numOne / 3) {
                    idxThird = i
                    break
                }
            }
        }
        val res1 = findEndIdx(A, 0, idxThird)
        if (res1 < 0) return noRes
        val res2 = findEndIdx(A, res1 + 1, idxThird)
        return if (res2 < 0) noRes else intArrayOf(res1, res2 + 1)
    }

    //right is the pattern to compare to.
    //return EndIdx of left pattern that matches right side.
    private fun findEndIdx(A: IntArray, left: Int, right: Int): Int {
        var left = left
        var right = right
        while (A[left] == 0) left++
        while (right < A.size) {
            if (A[left] != A[right]) return -1
            left++
            right++
        }
        return left - 1
    }
}