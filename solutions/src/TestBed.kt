import kotlin.time.measureTime


fun main(args: Array<String>) {
    println(measureTime {
        val tester = QueriesOnAPermutationWithKey()
        val results = listOf(
                tester.processQueries(intArrayOf(3,1,2,1),5)

        )
        println(results.map { it.toList() })
    })

}




