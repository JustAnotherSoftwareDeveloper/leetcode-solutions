import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {
        println("Starting")
        var edges = arrayOf(intArrayOf(2,1,1), intArrayOf(2,3,1), intArrayOf(3,4,1))
        val tester = NetworkDelayTime()
        val distance = tester.networkDelayTime(edges,4,2)
        println(distance)



    }
