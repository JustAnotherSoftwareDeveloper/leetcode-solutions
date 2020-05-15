import kotlin.time.measureTime


fun main(args: Array<String>) {
    println(measureTime {
        val tester =  ValidPathOnGrid()
        val results = listOf(
               //tester.hasValidPath(arrayOf(intArrayOf(2,4,3), intArrayOf(6,5,2)))
        tester.hasValidPath(arrayOf(intArrayOf(1,1,2)))
        )
        println(results.map { it })
    })

}




