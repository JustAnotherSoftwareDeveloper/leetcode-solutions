/**
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */
class BirthdayCakeCandles {

    fun birthdayCakeCandles(candles: Array<Int>) : Int {
        if (candles.isEmpty()) {
            return 0;
        }
        val max = candles.max()!!
        return candles.filter { it == max }.count()
    }
}