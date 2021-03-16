/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 */
class MinimumToAddToMakeParenthesisValid {
    fun minAddToMakeValid(S: String): Int {
        var toAdd = 0
        val stack = mutableListOf<Char>()
        S.forEach {
            if (it == '(') {
                stack.add(0,it)
            }
            if (it == ')') {
                if (stack.isEmpty() || stack.first() != '(') {
                    toAdd++
                }
                else {
                    stack.removeAt(0)
                }
            }
        }
        return toAdd+stack.size
    }
}