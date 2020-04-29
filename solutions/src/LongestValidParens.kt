/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
class LongestValidParens {

    fun longestValidParentheses(s: String): Int {
        val stack = mutableListOf<Int>()
        for (i in s.indices) {
            if (s[i] == '(') {
                stack.add(i)
            }
            else {
                if (stack.isEmpty()) {
                    stack.add(i)
                }
                else {
                    if (s[stack[stack.lastIndex]] == '(') {
                        stack.removeAt(stack.lastIndex)
                    }
                    else {
                        stack.add(i)
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return s.length
        }
        else {
            var longest = 0
            var end = s.length;
            var start : Int;
            while (stack.isNotEmpty()) {
                start = stack[stack.lastIndex]
                stack.removeAt(stack.lastIndex)
                longest = maxOf(longest,end-start-1)
                end = start
            }
            longest = maxOf(longest,end)
            return longest
        }
    }
}