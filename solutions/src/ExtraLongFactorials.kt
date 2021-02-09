import java.math.BigInteger

class ExtraLongFactorials {

    fun extraLongFactorials(n: Int) : Unit {
        val dpFactorial = mutableListOf<BigInteger>()
        var start = BigInteger.ONE;
        for (i in 2..n) {
            start = start.times(BigInteger.valueOf(i.toLong()))
        }
        println(start)
    }
}