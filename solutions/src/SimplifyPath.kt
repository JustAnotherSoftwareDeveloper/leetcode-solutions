/**
 * https://leetcode.com/problems/simplify-path/
 */
class SimplifyPath {
    fun simplifyPath(path: String) : String {
        val stack = mutableListOf<String>()
        var parts = path.split("/")
        for (i in parts.indices) {
            if (parts[i] == "..") {
                if (stack.isNotEmpty()) {
                    stack.removeAt(stack.lastIndex)
                }
            }
            else if (parts[i].isNotEmpty() && parts[i] != ".") {
                stack.add(parts[i])
            }
        }

        return stack.joinToString(separator = "/",prefix = "/",postfix = "")



    }
}