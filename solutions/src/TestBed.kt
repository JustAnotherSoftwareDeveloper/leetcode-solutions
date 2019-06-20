import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {

        val tester = CoinChange()


        val results = listOf(
                tester.coinChange(intArrayOf(186,419,83,408),6249)
        )
        println("Results")
        results.forEach { println(it) }



    }
