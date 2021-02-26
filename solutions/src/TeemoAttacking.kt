/**
 * https://leetcode.com/problems/teemo-attacking/
 */
class TeemoAttacking {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        val timeSet = mutableListOf<Pair<Int,Int>>()

        timeSeries.forEach {
            val start = it
            val end = it+duration
            if (timeSet.isEmpty()) {
                timeSet.add(Pair(start,end))
            }
            else {
                val latest = timeSet.last()
                if (latest.second >= start) {
                    timeSet.removeAt(timeSet.lastIndex)
                    timeSet.add(Pair(latest.first,end))
                }
                else {
                    timeSet.add(Pair(start,end))
                }
            }
        }
        return timeSet.map { it.second-it.first }.sum()


    }
}