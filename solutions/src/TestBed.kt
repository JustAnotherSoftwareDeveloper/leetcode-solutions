import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {

        val tester = ProductOfArrayExceptSelf()
        tester.productExceptSelf(intArrayOf(1,2,3,4))
        tester.productExceptSelf(intArrayOf(2,3,4,5))

}