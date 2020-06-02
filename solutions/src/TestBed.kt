import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = CourseScheduleTwo()
        val results = listOf(
                tester.findOrder(2, arrayOf(intArrayOf(1,0)))

        )
        println(results.map { it.toList() })
    })

}




