import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {

        val tester = CourseSchedule()
        tester.canFinish(3,arrayOf(intArrayOf(1,0), intArrayOf(2,1)))
        tester.canFinish(3, arrayOf(intArrayOf(1,0), intArrayOf(1,2), intArrayOf(0,1)))
        tester.canFinish(2, arrayOf(intArrayOf(1,0)))
        tester.canFinish(2, arrayOf(intArrayOf(0,1), intArrayOf(1,0)))


}