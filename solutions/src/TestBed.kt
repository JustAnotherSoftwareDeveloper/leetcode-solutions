import kotlin.time.measureTime


fun main(args: Array<String>) {
    println(measureTime {
        val tester = QueueReconstruction()
        val results = listOf(
            tester.reconstructQueue(arrayOf(intArrayOf(7,0), intArrayOf(4,4), intArrayOf(7,1), intArrayOf(5,0), intArrayOf(6,1), intArrayOf(5,2)))
        )
        println(results.map { it.toList().map {it2 -> it2.toList() } })
    })

}




