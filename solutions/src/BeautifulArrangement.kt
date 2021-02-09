/**
 * https://leetcode.com/problems/beautiful-arrangement/
 */
class BeautifulArrangement {

    var count = 0
    fun countArrangement(N: Int): Int {
        val visited = BooleanArray(N + 1)
        calculate(N, 1, visited)
        return count
    }

    private fun calculate(N: Int, pos: Int, visited: BooleanArray) {
        if (pos > N) count++
        for (i in 1..N) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true
                calculate(N, pos + 1, visited)
                visited[i] = false
            }
        }
    }
}