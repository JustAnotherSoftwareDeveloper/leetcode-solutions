import java.util.*
import java.util.Stack


/**
 * https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
 */

class CheckIfWordValidAfterSubstitutions {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (c in s.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') return false
                if (stack.isEmpty() || stack.pop() != 'a') return false
            } else {
                stack.push(c)
            }
        }
        return stack.isEmpty()
    }


}