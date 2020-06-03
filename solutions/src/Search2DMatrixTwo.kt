/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
class Search2DMatrixTwo {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) {
            return false
        }
        if (matrix[0].isEmpty()) {
            return false
        }
        for (i in matrix.indices) {
            if (matrix[i].binarySearch(target) >= 0) {
                return true
            }
        }
        for (j in matrix[0].indices) {
            if (binarySearchColumn(matrix,j,0,matrix.lastIndex,target)) {
                return true
            }
        }
        return false
    }

    private fun binarySearchColumn(matrix: Array<IntArray>, column: Int, lower: Int, upper: Int, target: Int) : Boolean {
        return if (lower > upper) {
            false
        }
        else {
            val mid = lower + (upper-lower)/2
            when {
                matrix[mid][column] == target -> {
                    true
                }
                matrix[mid][column] > target -> {
                    binarySearchColumn(matrix,column,lower,mid-1,target)
                }
                else -> {
                    binarySearchColumn(matrix,column,mid+1,upper,target)
                }
            }
        }
    }
}