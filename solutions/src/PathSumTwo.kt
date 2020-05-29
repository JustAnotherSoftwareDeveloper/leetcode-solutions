/**
 * https://leetcode.com/problems/path-sum-ii/submissions/
 */
class PathSumTwo {
    fun pathSum(root: TreeNode?, sum: Int) : List<List<Int>>{
       if (root == null) {
           return listOf()
       }
        val validPaths = mutableListOf<List<Int>>()
        val queue = mutableListOf(QueueItem(root,root.`val`, listOf(root.`val`)))
        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0)
            val leftNode = current.node.left
            val rightNode = current.node.right
            if (leftNode == null && rightNode == null) {
                if (sum == current.currSum) {
                    validPaths.add(current.currList)
                }
            }
            else {
                if (rightNode != null) {
                    queue.add(QueueItem(rightNode,current.currSum+rightNode.`val`,current.currList+rightNode.`val`))
                }
                if (leftNode != null) {
                    queue.add(QueueItem(leftNode,current.currSum+leftNode.`val`,current.currList+leftNode.`val`))
                }
            }
        }

        return validPaths
    }

    private class QueueItem(val node: TreeNode, val currSum: Int = 0, val currList : List<Int> = listOf())
}