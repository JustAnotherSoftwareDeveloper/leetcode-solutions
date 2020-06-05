import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = TopKFrequentElements()
        val results = listOf(
               tester.topKFrequent(intArrayOf(1,1,1,2,2,3),2)



        )
        println(results.map { it.toList() })
    })

}




