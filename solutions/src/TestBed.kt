import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = LongestWordInDictionaryThroughDeleting()
        val results = listOf(
              tester.findLongestWord("abpcplea", listOf("ale","apple","monkey","pea")),
                tester.findLongestWord("abpcplea", listOf("a","b","c"))



        )
        println(results.map { it })
    })

}




