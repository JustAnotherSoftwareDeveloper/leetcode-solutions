import java.util.*

class DailyTemperatures {

    fun dailyTemperatures(T: IntArray): IntArray {
        val stack = Stack<Int>()
        val daysToWait = IntArray(T.size)
        for (i in T.indices) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                val index = stack.pop()
                daysToWait[index] = i - index
            }
            stack.push(i)
        }
        return daysToWait

    }
}