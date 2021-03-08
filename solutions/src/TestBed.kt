import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = MinStepsToMakeAnagram()
        val result = listOf(
                tester.minSteps("anagram".reversed(),"anagram"),
                tester.minSteps("leetcode","practice"),
                tester.minSteps("bab","aba")
        )
        println(result)

    })

}




