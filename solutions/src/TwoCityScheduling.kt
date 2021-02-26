import java.util.*
import kotlin.Comparator
import kotlin.math.abs

/**
 * https://leetcode.com/problems/two-city-scheduling/
 */
class TwoCityScheduling {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        val cityComparator = Comparator<Pair<Int,Int>> { p1, p2 ->
            val p1Diff = abs(p1.first-p1.second)
            val p2Diff = abs(p2.first-p2.second)
            p1Diff.compareTo(p2Diff)
        }.reversed()

        val queue = PriorityQueue<Pair<Int,Int>>(cityComparator)

        costs.forEach {
            queue.add(Pair(it[0],it[1]))
        }

        var total = 0
        var citizensA = 0
        var citizensB = 0
        while (queue.isNotEmpty()) {
            val citizen = queue.poll()
            if (citizensA == costs.size/2) {
                total+=citizen.second
                citizensB++
            }
            else if (citizensB == costs.size/2) {
                total+=citizen.first
                citizensA++
            }
            else {
                if (citizen.first > citizen.second) {
                    total+=citizen.second
                    citizensB++
                }
                else {
                    total+=citizen.first
                    citizensA++
                }
            }
        }
        return total




    }
}