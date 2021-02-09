
import java.util.Arrays


/**
 * https://www.hackerrank.com/challenges/equal/problem
 */
class EqualChocolate {

    fun equal(arr:Array<Int>): Long {
        val cookies = arr.sortedArray();
        var sum = Long.MAX_VALUE
        for (base in 0..2) {
            var current_sum = 0
            for (i in cookies.indices) {
                val delta = cookies[i] - cookies[0] + base
                current_sum += delta / 5 + delta % 5 / 2 + delta % 5 % 2 / 1
            }
            sum = Math.min(current_sum.toLong(), sum)
        }
        return sum
    }
}