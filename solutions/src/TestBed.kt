import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = WaterAndJug()
        val results = listOf(

            tester.canMeasureWater(3,5,4),
                tester.canMeasureWater(5,3,4),
                tester.canMeasureWater(2,6,5),
                tester.canMeasureWater(6,2,5)


        )
        println(results.map { it })
    })

}




