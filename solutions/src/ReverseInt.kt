

class ReverseInt {
    //https://leetcode.com/problems/reverse-integer/description/
    fun reverse(x: Int): Int {
        var originalInteger = x
        var finalInt = 0
        while (originalInteger != 0) {
            val toAdd = originalInteger % 10
            if (finalInt.times(10.toLong()) > Int.MAX_VALUE  || finalInt.times(10.toLong()) < Int.MIN_VALUE) {
                return 0
            }
            finalInt *= 10
            finalInt += toAdd
            originalInteger = originalInteger.div(10)
        }
        return finalInt

    }

}