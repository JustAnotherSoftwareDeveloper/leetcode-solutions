//https://leetcode.com/problems/unique-paths/submissions/
class UniquePaths {
    fun uniquePaths(m: Int, n: Int) : Int {
        val grid = arrayOfNulls<IntArray>(m)
        for(i in 0 until m) {
            grid[i] = IntArray(n)
        }
        grid[0]!![0] = 1
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i+1 < m) {
                    grid[i+1]!![j]+=grid[i]!![j]
                }
                if (j+1 < n) {
                    grid[i]!![j+1]+=grid[i]!![j]
                }
            }
        }
        return grid[m-1]!![n-1]
    }
}