import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = CoinChangeProblem()
        val result = listOf(
               tester.getWays(4, arrayOf(1,2,3))
        )
        println(result)

    })

}




