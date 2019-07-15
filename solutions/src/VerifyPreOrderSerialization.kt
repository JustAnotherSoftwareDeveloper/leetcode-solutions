//https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
class VerifyPreOrderSerialization {

    fun isValidSerialization(preorder: String) : Boolean {
        val serialization = preorder.split(',')
        val stack = mutableListOf<String>()
        val canPopStack = {stack : List<String> ->
            if (stack.size < 3) {
                false
            }
            else {
                stack[stack.size-3] == "#" && stack[stack.size-2] == "#" && stack[stack.size -1] != "#"
            }
        }
        serialization.forEach {
            stack.add(it)
            while (canPopStack(stack)) {
                stack.removeAt(stack.lastIndex)
                stack.removeAt(stack.lastIndex)
                stack.removeAt(stack.lastIndex)

                stack.add("#")
            }
        }
        return stack.size == 1 && stack[0] == "#"

    }




}