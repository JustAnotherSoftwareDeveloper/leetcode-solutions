import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {

        val tester = LongestIncreasingSubsequence()
        tester.lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18))
        tester.lengthOfLIS(intArrayOf())
        tester.lengthOfLIS(intArrayOf(3,1,2,5))
        tester.lengthOfLIS(intArrayOf(1))


}