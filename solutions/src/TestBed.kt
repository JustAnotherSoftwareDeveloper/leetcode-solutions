import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = LongestSubstring2025()




        val result = listOf(
            tester.lengthOfLongestSubstring("abcabcbb"),
            tester.lengthOfLongestSubstring("bbbb"),
            tester.lengthOfLongestSubstring("pwwkew")
        )
        println(result)

    })

}





