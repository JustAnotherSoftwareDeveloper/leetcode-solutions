import kotlin.time.measureTime


fun main(args: Array<String>) {
    println(measureTime {
        val tester =  ConstructKPalindromeStrings()
        val results = listOf(
              tester.canConstruct("annabelle",2)
        )
        println(results.map { it })
    })

}




