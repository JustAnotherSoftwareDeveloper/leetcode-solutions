import kotlin.time.measureTime


fun main(args: Array<String>) {
    println(measureTime {
        val tester = RemoveDuplicatesFromSortedArrayTwo()
        val results = listOf(
            tester.removeDuplicates(intArrayOf(1,1,1,2,2,3))
        )
        println(results.map { it })
    })

}




