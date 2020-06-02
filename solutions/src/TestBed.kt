import kotlin.time.measureTime


fun main(args: Array<String>) {
    println(measureTime {
        val tester =  OutOfBoundsPaths()
        val results = listOf(
                tester.findPaths(1,3,3,0,1)

        )
        println(results.map { it })
    })

}




