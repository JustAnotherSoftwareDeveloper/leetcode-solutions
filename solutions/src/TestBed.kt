import kotlin.time.measureTime


fun main(args: Array<String>) {
    println(measureTime {
        val tester =  LetterTilePossibilities()
        val results = listOf(
              tester.numTilePossibilities("AAB")
        )
        println(results.map { it })
    })

}




