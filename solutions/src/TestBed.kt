import kotlin.time.measureTime


fun main(args: Array<String>) {
    println(measureTime {
        val tester =  MaxDiffYouCanGetFromChangingInteger()
        val results = listOf(
               tester.maxDiff(555),
                tester.maxDiff(9),
                tester.maxDiff(123456),
                tester.maxDiff(10000),
                tester.maxDiff(9288)
        )
        println(results.map { it })
    })

}




