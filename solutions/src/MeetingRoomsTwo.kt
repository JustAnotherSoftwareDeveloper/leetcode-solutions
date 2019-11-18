import java.util.*

class MeetingRoomsTwo {
    fun minMeetingRooms(intervals: Array<IntArray>) : Int {
        var numRooms = 0
        var roomEndingTimes = PriorityQueue<Int>()
        val roomsSorted = intervals.map { Pair(it[0],it[1]) }.sortedWith(compareBy({it.first},{it.second}))
        roomsSorted.forEach {
            val minTime = roomEndingTimes.peek()
            println("Min Ending Time ${minTime ?: null}. Meeting Starts at ${it.first}")
            when {
                minTime == null -> numRooms++
                minTime > it.first -> numRooms++
                else -> roomEndingTimes.poll()
            }
            roomEndingTimes.add(it.second)
        }
        return numRooms
    }
}