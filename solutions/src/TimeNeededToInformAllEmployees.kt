/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 */
class TimeNeededToInformAllEmployees {

    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val hierarchy = mutableMapOf<Int,MutableList<Int>>();
        val timeToInform = mutableMapOf<Int,Int>()
        timeToInform[-1] = 0

        manager.forEachIndexed { index, i ->
            hierarchy.computeIfAbsent(i){ mutableListOf()}.add(index)
        }

        val queue = mutableListOf(-1)
        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0)
            val informTimeForSupervisor = timeToInform[current]!!
            val timeSupervisorTakesToInform = if (current == -1) {
                0
            } else {
                informTime[current]
            }
            hierarchy.getOrDefault(current, mutableListOf()).forEach {
                timeToInform[it] = informTimeForSupervisor+timeSupervisorTakesToInform
                queue.add(it)
            }
        }


        return timeToInform.values.max()!!
    }
}