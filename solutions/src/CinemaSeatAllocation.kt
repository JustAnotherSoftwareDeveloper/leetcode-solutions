
import java.util.*


/**
 * https://leetcode.com/problems/cinema-seat-allocation/
 * Got the answer, but it was too memory complex. It wanted
 * me to use bitwise.
 */
class CinemaSeatAllocation {
    fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
        val graph: MutableMap<Int, Int> = HashMap()
        for (reserved in reservedSeats) {
            val row = reserved[0]
            val col = reserved[1]
            graph[row] = graph.getOrDefault(row, 0) or (1 shl col) // create a bit vector of reserved seats
        }
        var max = 0
        for (row in graph.keys) {
            val reserved = graph[row]!!
            var cnt = 0
            if (reserved and 60 == 0) cnt += 1 // check if seats 2,3,4,5 are available
            if (reserved and 960 == 0) cnt += 1 // check if seats 6,7,8,9 are available
            if (reserved and 240 == 0 && cnt == 0) cnt = 1 // check if seats 4,5,6,7 are available
            max += cnt
        }
        return max + 2 * (n - graph.size)
    }
}