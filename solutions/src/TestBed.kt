import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = LongestCommonPrefix()


        val result = listOf(
            tester.longestCommonPrefix(arrayOf("flower","flow","flight")),
            tester.longestCommonPrefix(arrayOf("dog","car","bed")),
            tester.longestCommonPrefix(arrayOf("racecar","dog","car")),
            tester.longestCommonPrefix(arrayOf("flow","flow","flower")),
            tester.longestCommonPrefix(arrayOf("flow","flow","flow"))
        )
        println(result)

    })

}





