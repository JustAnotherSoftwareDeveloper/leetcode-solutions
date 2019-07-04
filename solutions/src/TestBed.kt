import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {

        val tester = NonOverlappingIntervals()

        tester.eraseOverlapIntervals(arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(1,3)))
        tester.eraseOverlapIntervals(arrayOf(intArrayOf(1,2), intArrayOf(1,2), intArrayOf(1,2)))
        tester.eraseOverlapIntervals(arrayOf(intArrayOf(1,2), intArrayOf(2,3)))


    }
