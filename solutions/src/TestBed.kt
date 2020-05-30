import kotlin.time.measureTime


fun main(args: Array<String>) {
    println(measureTime {
        val tester =  isSubsequenceOne()
        val results = listOf(
            tester.isSubsequence("abc","ahbgdc"),
                tester.isSubsequence("axc","ahbdgc"),
            tester.isSubsequence("","ahbdgc")
        )
        println(results.map { it })
    })

}




