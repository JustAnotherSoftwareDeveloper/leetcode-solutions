import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = QueensAttackTwo()
        val results = tester.queensAttack(4,0,4,4, arrayOf())
        println(results)
    })

}




