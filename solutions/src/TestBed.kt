import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = MinimumDeletionCostToAvoidRepeatingLetters()
        val result = listOf(
                tester.minCost("abaac", intArrayOf(1,2,3,4,5)),
                tester.minCost("abc", intArrayOf(1,2,3)),
                tester.minCost("aabaa", intArrayOf(1,2,3,4,1))
        )
        println(result)

    })

}




