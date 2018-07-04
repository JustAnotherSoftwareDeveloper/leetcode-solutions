import kotlin.math.sign

class ReverseInt {
    fun reverse(x: Int): Int {
        var originalInteger = x
        var finalInt = 0
        while (originalInteger > 0 || originalInteger < 0) {
            val toAdd = originalInteger % 10
            finalInt *= 10
            finalInt += toAdd
            originalInteger = originalInteger.div(10)
        }
        if (switchedSign(x,finalInt)) { //Overflow
            return 0
        }
        return finalInt

    }


    private fun switchedSign(initial: Int, current: Int): Boolean {
        if (initial >= 0 && current >= 0) {
            return false
        }
        else if (initial <=0 && current <=0) {
            return false
        }
        return true
    }

}