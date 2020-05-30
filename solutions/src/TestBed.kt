import kotlin.time.measureTime


fun main(args: Array<String>) {
    println(measureTime {
        val tester =  MaximumSubArraySum()
        val results = listOf(
                tester.kConcatenationMaxSum(intArrayOf(-5,-2,0,0,3,9,-2,-5,4),5)

        )
        println(results.map { it })
    })

}




