import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = ReverseSubstringParenthesis()
        val result = listOf(
                tester.reverseParentheses("(u(love)i)"),
                tester.reverseParentheses("a(bcdefghijkl(mno)p)q"),
            tester.reverseParentheses("(abcd)"),

                tester.reverseParentheses("(ed(et(oc))el)")
        )
        println(result)

    })

}




