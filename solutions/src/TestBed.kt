import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {

        val tester = DecodeWays()

        tester.numDecodings("12")
        tester.numDecodings("226")
        tester.numDecodings("001")
        tester.numDecodings("0")
        tester.numDecodings("01")
    }
