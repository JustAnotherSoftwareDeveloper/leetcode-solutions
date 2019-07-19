import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {

        val tester = CanIWinSol()
        tester.canIWin(10,40)
        tester.canIWin(10,10)
        tester.canIWin(10,11)



}