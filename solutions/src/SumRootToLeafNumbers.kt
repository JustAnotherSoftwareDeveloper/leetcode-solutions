/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
class SumRootToLeafNumbers {
    fun sumNumbers(root: TreeNode?) : Int {
        if (root == null) {
            return 0
        }
        val queue= mutableListOf(QueueItem(root,root.`val`.toString()))
        val finishedStrings = mutableListOf<String>()
        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0)
            val currentNode = current.node
            val currentStr = current.str
            if (currentNode.left == null && currentNode.right == null) {
                finishedStrings.add(currentStr)
            }
            else {
                val toQueue = mutableListOf<QueueItem>()
                if (currentNode.left != null) {
                    toQueue.add(QueueItem(currentNode.left!!,currentStr+currentNode.left!!.`val`))
                }
                if (currentNode.right != null) {
                    toQueue.add(QueueItem(currentNode.right!!,currentStr+currentNode.right!!.`val`))
                }
                queue.addAll(toQueue)
            }

        }
        return finishedStrings.map { it.toInt() }.sum()
    }

    private class QueueItem(val node: TreeNode, val str: String)
}