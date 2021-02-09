import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = MatrixBlockSum();
        val results =FindPathInZigZagTree().pathInZigZagTree(14)
        println(results)
    })

}




