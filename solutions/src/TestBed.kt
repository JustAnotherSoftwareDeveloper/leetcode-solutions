import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {

        val tester = SearchRotatedSortedArray()

        val arrOne = intArrayOf(5,1,3)
        var arrTwo = intArrayOf(3,5,1)


        val results = listOf(
                tester.search(intArrayOf(2,4,5,6,7,0,1),0),
                tester.search(intArrayOf(5,1,3),1),
                tester.search(intArrayOf(3,5,1,2),5),
                tester.search(intArrayOf(1),1),
                tester.search(intArrayOf(3,1),0),
                tester.search(intArrayOf(3,1),1)
        )
        println("Results")
        results.forEach { println(it) }



    }
