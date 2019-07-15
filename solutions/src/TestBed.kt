import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {

        val tester = JumpGameTwo()
        tester.jump(intArrayOf(4,1,1,3,1,1,1))
        tester.jump(intArrayOf(2, 3, 1, 1, 4))
        tester.jump(intArrayOf(3, 5, 2))

}