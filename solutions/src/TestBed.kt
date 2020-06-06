import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
<<<<<<< HEAD
        val tester =  ChampagneTower()
        val results = listOf(
                tester.champagneTower(1,1,1),
                tester.champagneTower(2,1,1)
=======
        val tester = TopKFrequentElements()
        val results = listOf(
               tester.topKFrequent(intArrayOf(1,1,1,2,2,3),2)


>>>>>>> refs/remotes/origin/master

        )
        println(results.map { it.toList() })
    })

}




