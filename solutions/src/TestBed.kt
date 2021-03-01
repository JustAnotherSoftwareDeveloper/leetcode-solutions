import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = GrumpyBookstoreOwner()
        val result = listOf(
                tester.maxSatisfied(intArrayOf(1,0,1,2,1,1,7,5), intArrayOf(0,1,0,1,0,1,0,1),3)
        )
        println(result)

    })

}




