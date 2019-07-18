//https://leetcode.com/problems/course-schedule/
class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>) : Boolean {
        val courseToPostReq : MutableMap<Int,MutableSet<Int>> = mutableMapOf()
        val courseToPreReq : MutableMap<Int,MutableSet<Int>> = mutableMapOf()
        for (i in 0 until numCourses) {
            courseToPreReq[i] = mutableSetOf()
            courseToPostReq[i] = mutableSetOf()
        }
        prerequisites.forEach {
            courseToPostReq[it[1]]!!.add(it[0])
            courseToPreReq[it[0]]!!.add(it[1])
        }
        val queue = courseToPreReq.filter { it.value.isEmpty()}.map { it.key }.toMutableList()


        while (queue.isNotEmpty()) {
            val course = queue.removeAt(0)
            val childCourses = courseToPostReq[course]!!
            childCourses.filter {
                courseToPreReq[it]!!.remove(course)
                courseToPreReq[it]!!.isEmpty()
            }.forEach { queue.add(it) }
        }
        println(courseToPreReq.all {it.value.isEmpty()})
        return courseToPreReq.all { it.value.isEmpty() }

    }


}