import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = ArrayNesting()
        val result = listOf(
                tester.arrayNesting(intArrayOf(5,4,0,3,1,6,2))
        )
        println(result)

    })

}




