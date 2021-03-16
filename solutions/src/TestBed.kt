import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = DeleteNodesAndReturnForest()


        val result = listOf(
                traverse1()
        )
        println(result)

    })

}

private fun traverse1() : List<Int> {
    val tester = DeleteNodesAndReturnForest()
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.right!!.right = TreeNode(4)
    return tester.delNodes(root, intArrayOf(1,2)).map { it!!.`val` }
}




