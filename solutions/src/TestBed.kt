import kotlin.time.measureTime


fun main(args: Array<String>) {
    println(measureTime {
        val tester =  ChampagneTower()
        val results = listOf(
                tester.champagneTower(1,1,1),
                tester.champagneTower(2,1,1)

        )
        println(results.map { it })
    })

}




