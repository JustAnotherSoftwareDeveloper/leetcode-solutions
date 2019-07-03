import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {

        val tester = MaximumSubarray()

        tester.maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)) // 6
        tester.maxSubArray(intArrayOf(-1,0,-2,2)) // 2
        tester.maxSubArray(intArrayOf(-2,1)) // 1
        tester.maxSubArray(intArrayOf(1,-2,0)) // 1
        tester.maxSubArray(intArrayOf(-1)) // -1


    }
