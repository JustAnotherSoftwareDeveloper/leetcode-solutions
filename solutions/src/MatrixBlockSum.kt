import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/matrix-block-sum/
 */
class MatrixBlockSum {

    fun matrixBlockSum(mat: Array<IntArray>, K: Int) : Array<IntArray> {
        val sumMatrix = Array(mat.size+1){IntArray(mat[0].size+1){0} };
        val m = mat.size;
        val n = mat[0].size
        for (i in 1..mat.size) {
            for (j in 1..mat[0].size) {
                val prevMat = mat[i-1][j-1];
                val prevSum = sumMatrix[i-1][j-1];
                val prevI = sumMatrix[i-1][j]
                val prevJ = sumMatrix[i][j-1]
                sumMatrix[i][j] = prevMat+prevI+prevJ-prevSum;
            }
        }
        val ans = Array(m) { IntArray(n) }
        for (r in 0 until m) {
            for (c in 0 until n) {
                var r1 = max(0, r - K)
                var c1 = max(0, c - K)
                var r2 = min(mat.size- 1, r + K)
                var c2 = min(mat[0].size - 1, c + K)
                r1++
                c1++
                r2++
                c2++ // Since `sum` start with 1 so we need to increase r1, c1, r2, c2 by 1
                ans[r][c] = sumMatrix[r2][c2] - sumMatrix[r2][c1 - 1] - sumMatrix[r1 - 1][c2] + sumMatrix[r1 - 1][c1 - 1]
            }
        }
        return ans
    }
}