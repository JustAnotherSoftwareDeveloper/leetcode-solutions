import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {

        val tester =  PacificAtlanticWaterFlow()
        val results = listOf(
                tester.pacificAtlantic(
                        arrayOf(
                                intArrayOf(1,2,2,3,5),
                                intArrayOf(3,2,3,4,4),
                                intArrayOf(2,4,5,3,1),
                                intArrayOf(6,7,1,4,5),
                                intArrayOf(6,1,1,2,4)
                        )
                )
        )
        println(results.map { it })
    })

}




