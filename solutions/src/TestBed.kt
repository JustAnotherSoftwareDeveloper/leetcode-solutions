import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = RevealCardsInIncreasingOrder()
        val results = listOf(
           tester.deckRevealedIncreasing(intArrayOf(17,13,11,2,3,5,7))
        )
        results.forEach { println(it.toList()) }
    })

}




