import kotlin.time.measureTime


fun main(args: Array<String>) {
    println(measureTime {
        val tester =  RestoreIpAddresses()
        val results = listOf(
              tester.restoreIpAddresses("25525511135"),
                tester.restoreIpAddresses("010010")
        )
        println(results.map { it })
    })

}




