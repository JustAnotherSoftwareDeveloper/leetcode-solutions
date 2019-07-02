import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {

        val tester = NumArray(intArrayOf(-2,0,3,-5,2,-1))

        println(tester.sumRange(0,2))
        println(tester.sumRange(2,5))
        println(tester.sumRange(0,5))



    }
