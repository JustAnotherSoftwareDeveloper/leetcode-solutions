/**
 * https://leetcode.com/problems/min-stack/submissions/
 */
class MinStack {

    val minStack = mutableListOf<Int>()
    val orderStack = mutableListOf<Int>()
    fun push(`val`: Int) {
        orderStack.add(`val`)
        if (minStack.isEmpty()) {
            minStack.add(`val`)
        }
        else if (minStack.first() > `val`) {
            minStack.add(`val`)
        }
        else {
            minStack.add(minStack.last())
        }
    }

    fun pop() {
        if (orderStack.isNotEmpty()) {
            minStack.removeAt(minStack.lastIndex)
            orderStack.removeAt(orderStack.lastIndex)
        }
    }

    fun top(): Int {
        return orderStack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }
}