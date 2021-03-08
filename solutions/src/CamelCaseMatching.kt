/**
 * https://leetcode.com/problems/camelcase-matching/
 */
class CamelCaseMatching {

    fun camelMatch(queries: Array<String>, pattern: String): BooleanArray {
        val lowers = "abcdefghijklmnopqrstuvwxyz"
        val uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

        val patternStack = pattern.toList()

        return queries.map {
            val copyStack = patternStack.toMutableList()
            isValid(it,copyStack)
        }.toBooleanArray()
    }

    private fun isValid(s: String, stack: MutableList<Char>) : Boolean {
        s.forEach {
            if (stack.isEmpty()) {
                if (it.isUpperCase()) {
                    return false
                }
            }
            else {
                val top = stack[0]
                if (it == top) {
                    stack.removeAt(0)
                }
                else if (it.isUpperCase()) {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}