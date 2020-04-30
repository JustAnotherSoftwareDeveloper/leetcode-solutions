/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
class SeachMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int) : Boolean {
        if (matrix.isEmpty()) {
            return false;
        }
        val rowToSearch = searchColumn(matrix,target,0,matrix.lastIndex)
        return binarySearch(array = matrix[rowToSearch], target = target, low = 0, high = matrix[rowToSearch].lastIndex)
    }

    private fun binarySearch(array: IntArray, target: Int,low: Int,high: Int) : Boolean {
        if (low > high || array.isEmpty()) {
            return false
        }
        val mid = (high-low)/2 + low
        return when {
            target == array[mid] -> true
            target > array[mid] -> binarySearch(array,target,mid+1,high)
            else -> binarySearch(array,target,low,mid-1)
        }
    }

    private fun searchColumn(matrix: Array<IntArray>, target: Int, low: Int, high : Int) : Int {
        if (high == low) {
            return high
        }
        val mid = (high-low)/2 + low
        return when {
            target >= matrix[mid][0] && target <= matrix[mid][matrix[0].lastIndex] -> {
                mid
            }
            target > matrix[mid][matrix[0].lastIndex] -> {
                searchColumn(matrix,target,mid+1,high)
            }
            else -> {
                searchColumn(matrix,target,low,mid)
            }
        }
    }
}