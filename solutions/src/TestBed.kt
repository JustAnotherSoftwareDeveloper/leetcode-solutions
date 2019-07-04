import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {

        val tester = NumArrayMutable(intArrayOf(7,2,7,2,0))
        tester.update(4,6)
        tester.update(0,2)
        tester.update(0,9)
        tester.sumRange(4,4) // 6

        tester.update(3,8)
        tester.sumRange(0,4) // 32
        tester.update(4,1)
        tester.sumRange(0,3) //26
        tester.sumRange(0,4) //27
        tester.update(0,4)

    }
