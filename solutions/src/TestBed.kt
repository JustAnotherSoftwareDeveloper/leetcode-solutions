import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = TorqueAndDevelopment()
        val result = listOf(
                tester.roadsAndLibraries(
                  5,
                  92,
                  23,
                  arrayOf(
                          arrayOf(2,1),
                          arrayOf(5,1),
                          arrayOf(5,3),
                          arrayOf(3,4),
                          arrayOf(3,1),
                          arrayOf(5,4),
                          arrayOf(4,1),
                          arrayOf(5,2),
                          arrayOf(4,2)
                  )
                ),
                tester.roadsAndLibraries(
                        9,
                        91,
                        84,
                        arrayOf(
                                arrayOf(8,2),
                                arrayOf(2,9),
                        )
                ),
                tester.roadsAndLibraries(
                        3,
                        2,
                        1,
                        arrayOf(
                                arrayOf(1,2),
                                arrayOf(3,1),
                                arrayOf(2,3)
                        )
                ),
                tester.roadsAndLibraries(
                        6,
                        2,
                        5,
                        arrayOf(
                                arrayOf(1,3),
                                arrayOf(3,4),
                                arrayOf(2,4),
                                arrayOf(1,2),
                                arrayOf(2,3),
                                arrayOf(5,6)
                        )
                )
        )
        println(result)

    })

}




