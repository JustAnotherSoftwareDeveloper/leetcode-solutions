import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = Search2DMatrixTwo()
        val results = listOf(
                tester.searchMatrix(
                        arrayOf(
                                intArrayOf(1,4,7,11,15),
                                intArrayOf(2,5,8,12,19),
                                intArrayOf(3,6,9,16,22),
                                intArrayOf(10,13,14,17,24),
                                intArrayOf(18,21,23,26,30)
                        ),
                        20
                )

        )
        println(results.map { it })
    })

}




