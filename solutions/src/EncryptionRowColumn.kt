import java.lang.StringBuilder
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

/**
 * https://www.hackerrank.com/challenges/encryption/problem
 */
class EncryptionRowColumn {

    // Complete the encryption function below.
    fun encryption(s: String): String {
        val sWithoutSpaces = s.filter { it != ' ' };

        val sqrtSize = sqrt(sWithoutSpaces.length.toDouble());

        val upper = ceil(sqrtSize).toInt()
        val lower = floor(sqrtSize).toInt()

        var column: Int;
        var row: Int;

        when {
            lower*lower >= sWithoutSpaces.length -> {
                column = lower
                row = lower
            }
            upper*lower >= sWithoutSpaces.length -> {
                column = upper;
                row = lower
            }
            else -> {
                column = upper
                row = upper
            }
        }
        var total = 0
        var i = 0
        var sb = StringBuilder()
        var arr = Array(row){CharArray(column)}
        for(i in 0 until row ){
            for (j in 0 until column) {
                if (total < sWithoutSpaces.length) {
                    arr[i][j] = sWithoutSpaces[total]
                    total++
                }

            }


        }

        for (j in 0 until column) {
            for (i in 0 until row) {
                sb.append(arr[i][j])
            }
            if (j != column-1) {
                sb.append(' ')
            }
        }
        return sb.toString().trim()

    }
}