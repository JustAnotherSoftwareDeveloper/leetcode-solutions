import java.math.BigInteger
import java.util.*
import kotlin.concurrent.timer

class RemoveKDigits {

    fun removeKdigits(num: String, k: Int) : String {

        val stack = Stack<Char>()
        if (num.length == k) {
            return "0"
        }
        var i = 0
        var toRemove = k
        while (i < num.length) {
            while (toRemove > 0 && stack.isNotEmpty() && stack.peek() > num[i]) {
                stack.pop()
                toRemove--
            }
            stack.push(num[i])
            i++;
        }
        while (toRemove > 0) {
            stack.pop()
            toRemove--
        }
        var new = ""
        val reversed = stack.reversed().toMutableList()
        while (stack.isNotEmpty()) {
            new+=stack.pop()
        }
        new = new.reversed()
        while (new.length > 1 && new[0] == '0') {
            new = new.substring(1)
        }
        return new
    }


}