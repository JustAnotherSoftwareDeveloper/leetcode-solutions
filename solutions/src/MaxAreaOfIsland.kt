/**
 * https://leetcode.com/problems/max-area-of-island/
 */
class MaxAreaOfIsland {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxSize = 0;
        for (i in grid.indices) {
            for (j in grid[0].indices) {

                if (grid[i][j] == 1) {
                    var currSize = 0;
                    val queue = mutableListOf(Pair(i,j))
                    while (queue.isNotEmpty()) {
                        val curr = queue.removeAt(0);
                        if (curr.first < 0 || curr.first >= grid.size || curr.second < 0 || curr.second >= grid[0].size) {
                            continue;
                        }
                        if (grid[curr.first][curr.second] != 1) {
                            continue;
                        }
                        currSize++;
                        grid[curr.first][curr.second]= -1;
                        queue.addAll(
                                mutableListOf(
                                        Pair(curr.first+1,curr.second),
                                        Pair(curr.first-1,curr.second),
                                        Pair(curr.first,curr.second+1),
                                        Pair(curr.first,curr.second-1)
                                )
                        );
                    }
                    maxSize = maxOf(maxSize,currSize)
                }
            }
        }
        return maxSize
    }
}