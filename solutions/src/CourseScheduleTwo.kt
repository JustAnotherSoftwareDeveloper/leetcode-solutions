/**
 * https://leetcode.com/problems/course-schedule-ii/
 */
class CourseScheduleTwo {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val courePrereqs = (0 until numCourses).map { Pair(it, mutableSetOf<Int>()) }.toMap().toMutableMap()
        val courseToListOfCoursesThatNeedIt = (0 until numCourses).map { Pair(it, mutableSetOf<Int>()) }.toMap().toMutableMap()
        prerequisites.forEach { desc ->
            val prereqList = mutableListOf<Int>()
            for(i in 1 until desc.size) {
                prereqList.add(desc[i])
                courseToListOfCoursesThatNeedIt.computeIfAbsent(desc[i]) { mutableSetOf()}.add(desc[0])
            }
            courePrereqs.computeIfAbsent(desc[0]) { mutableSetOf()}.addAll(prereqList)
        }
        val availableCourses = courePrereqs.filter { it.value.isEmpty() }.map { it.key }.toMutableList()
        availableCourses.forEach{
            courePrereqs.remove(it)
        }
        val courseSchedule = mutableListOf<Int>()
        val visited = availableCourses.toMutableSet()
        while (availableCourses.isNotEmpty()) {
            val current = availableCourses.removeAt(0)
            courseSchedule.add(current)
            val toQueue = mutableListOf<Int>()
            courseToListOfCoursesThatNeedIt.getOrDefault(current, mutableSetOf()).forEach {
                val preReqSet = courePrereqs[it]!!
                preReqSet.remove(current)
                if (preReqSet.isEmpty()) {
                    courePrereqs.remove(it)
                    toQueue.add(it)

                }
            }
            availableCourses.addAll(toQueue)

        }
        return if (courseSchedule.size != numCourses) intArrayOf() else courseSchedule.toIntArray()



    }
}