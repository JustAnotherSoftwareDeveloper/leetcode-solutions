import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = SumOfAbsoluteDifferences()
        val result = listOf(
                tester.getSumAbsoluteDifferences(intArrayOf(2,3,5)).toList(),
                tester.getSumAbsoluteDifferences(intArrayOf(1,4,6,8,10)).toList()
        )
        println(result)

    })

}




