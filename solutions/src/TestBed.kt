import kotlin.time.measureTime


fun main(args: Array<String>) {
    println(measureTime {
        val tester = SimplifyPath()
        val results = listOf(
            //tester.simplifyPath("/../"),
                //tester.simplifyPath("/"),
                //tester.simplifyPath("/home//foo/"),
                //tester.simplifyPath("/a/./b/../../c/"),
                tester.simplifyPath("/a/../../b/../c//.//")

        )
        println(results.map { it })
    })

}




