import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {
        println("Starting")
        val days = intArrayOf(1,2,3,4,6,8,9,10,13,14,16,17,19,21,24,26,27,28,29)
        val costs = intArrayOf(3,14,50)
        val tester = MinCostForTickets()
        val minCost = tester.mincostTickets(days,costs)
        println(minCost)



    }
