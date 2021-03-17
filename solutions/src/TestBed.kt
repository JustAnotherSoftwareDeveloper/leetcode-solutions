import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = RankTeamsByVotes()


        val result = listOf(
                tester.rankTeams(
                        arrayOf(
                                "BCA",
                                "CAB",
                                "CBA",
                                "ABC",
                                "ACB",
                                "BAC"
                        )
                ),
                tester.rankTeams(arrayOf(
                   "WXYZ",
                   "XYZW"
                )),
                tester.rankTeams(arrayOf(
                        "ABC",
                        "ACB",
                        "ABC",
                        "ACB",
                        "ACB"
                ))
        )
        println(result)

    })

}





