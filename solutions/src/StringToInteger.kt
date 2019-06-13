import java.math.BigInteger
import java.util.*

class StringToInteger {

    fun myAtoi(str: String): Int {
        val separated = Regex("\\s+").split(str).filter { it != null }.filter { it != "" }
        return when {
            separated.isEmpty() -> 0
            !Regex("\\A[+-]?0*[1-9].*").matches(separated[0]) -> 0
            else -> {
                var normalized = separated[0].replaceFirst(Regex("\\A+"),"")
                normalized.replace(Regex("\\A0+[1-9]")) {it.value.replace("0","")}
                normalized = Regex("-?\\d+").find(normalized)?.value!!
                val convertedValue = BigInteger(normalized)
                if (convertedValue > BigInteger.valueOf(Int.MAX_VALUE.toLong())) {
                    return Int.MAX_VALUE
                }
                else if (convertedValue < BigInteger.valueOf(Int.MIN_VALUE.toLong()) ) {
                    return Int.MIN_VALUE
                }
                return convertedValue.toInt()
            }
        }
    }
}