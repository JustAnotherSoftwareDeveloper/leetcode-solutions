import kotlin.math.max
https://leetcode.com/problems/task-scheduler/submissions/
class TaskScheduler {
    fun leastInterval(tasks: CharArray, n : Int) : Int {

        val tasksByType = tasks.toList().groupingBy { it }.eachCount().toMutableMap()  // O(n)
        var tasksByPosition : MutableMap<Char,Int>  = tasks.associate { it to 0 }.toMutableMap() // O(n)
        var totalTasks = tasks.size // O(1)
        var totalTime = 0

        while (totalTasks != 0) {
            totalTime++
            val currentTaskType = tasksByPosition.entries.filter { it.value == 0 }.filter { tasksByType[it.key]!! != 0 }.map { it.key }.sortedByDescending { tasksByType[it]!! }.firstOrNull() // O(1)
            if (currentTaskType != null) {
                totalTasks --
                tasksByType[currentTaskType]= tasksByType[currentTaskType]!!-1
                tasksByPosition[currentTaskType] = n
                tasksByPosition.keys.filter { it != currentTaskType }.forEach{ tasksByPosition[it] = max(0,tasksByPosition[it]!! -1)} // O(1)
            }
            else {
                tasksByPosition.keys.forEach { tasksByPosition[it] = max(0, tasksByPosition[it]!!-1) } // O(1)
            }
        }
        println(totalTime)
        return totalTime



    }
}