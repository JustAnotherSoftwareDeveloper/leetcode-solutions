import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = SearchInsertPosition()


        val result = listOf(
            tester.searchInsert(intArrayOf(1,3),0),
           tester.searchInsert(intArrayOf(1,3,5,6),5),
            tester.searchInsert(intArrayOf(1,3,5,6),2),
            tester.searchInsert(intArrayOf(1,3,5,6),7),
            tester.searchInsert(intArrayOf(1,3,5,6),1),
            tester.searchInsert(intArrayOf(1,3,5,6),0)
        )
        println(result)

    })

}





