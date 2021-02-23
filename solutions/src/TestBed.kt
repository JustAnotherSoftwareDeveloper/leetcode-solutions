import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = MaxScoreFromRemovingStones()
        val result = listOf(
                tester.maximumScore(2,4,6),
                tester.maximumScore(4,4,6)
        )
        println(result)

    })

}




