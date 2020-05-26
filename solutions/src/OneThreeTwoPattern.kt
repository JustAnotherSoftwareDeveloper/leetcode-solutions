/**
 * https://leetcode.com/problems/132-pattern/
 */
class OneThreeTwoPattern {

    fun find132pattern(nums: IntArray) : Boolean {
       val stack = mutableListOf<Pair<Int,Int>>()
        nums.forEach {
            if (stack.isEmpty() || it < stack.last().first) {
                stack.add(Pair(it,it))
            }
            else if (it > stack.last().first) {
                val last = stack.removeAt(stack.lastIndex)
                if (it < last.second) {
                    return true
                }
                else {
                    val toAdd = Pair(last.first,it)
                    while (stack.isNotEmpty() && it >= stack.last().second) {
                        stack.removeAt(stack.lastIndex)
                    }
                    if (stack.isNotEmpty() && stack.last().first < it) {
                        return true
                    }
                    stack.add(toAdd)
                }
            }
        }
        return false
    }
}