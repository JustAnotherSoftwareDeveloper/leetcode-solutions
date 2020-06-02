/**
 * https://www.hackerrank.com/challenges/sparse-arrays/problem
 */
class SparseArrays {
    fun matchingStrings(strings: Array<String>, queries: Array<String>): Array<Int> {
        val stringsByOccurance = strings.groupingBy { it }.eachCount()
        return queries.map { stringsByOccurance[it] ?: 0 }.toTypedArray()

    }

}