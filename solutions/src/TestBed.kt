import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = SherlockAndCost()
        val results = tester.cost(arrayOf(1,2,3))
        println(results)
    })

}




