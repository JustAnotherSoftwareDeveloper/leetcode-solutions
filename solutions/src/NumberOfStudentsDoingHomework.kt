/**
 * https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
 */
class NumberOfStudentsDoingHomework {

    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int) : Int {
        if (startTime.isEmpty()) {
            return 0
        }
        val timeMatches = mutableListOf<Pair<Int,Int>>()
        for (i in startTime.indices) {
            timeMatches.add(Pair(startTime[i],endTime[i]))
        }

        return timeMatches.filter { it.first <= queryTime && it.second >= queryTime }.count()
    }
}