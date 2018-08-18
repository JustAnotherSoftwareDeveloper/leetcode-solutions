import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis


fun  main(args: Array<String>) {
        println("Starting")
        for (i in 0 until 10) {
            println("${measureTimeMillis{
                val N = 1000000
                val B = 1000
                val blacklist = listOf(0..B).flatMap { it }.toIntArray()

                val randomizer = RandomWithBlacklist(N,blacklist)
                for (j in 0 until 50000) {
                    randomizer.pick()
                }
            }}ms")
        }



    }
