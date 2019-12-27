class BSTtoGST {

    private var maxVal: Int = 0
    fun bstToGst(root: TreeNode?) : TreeNode? {
        maxVal = 0
        return traverse(root)
    }

    fun traverse(node: TreeNode?) : TreeNode? {
        if (node == null) {
            return null
        }
        val summedNode = TreeNode(node.`val`)
        val rightVal = traverse(node.right)
        summedNode.`val` += maxVal
        maxVal = maxOf(maxVal,summedNode.`val`)
        val leftVal = traverse(node.left)
        summedNode.left = leftVal
        summedNode.right = rightVal
        return summedNode
    }


    class TreeNode(var `val` : Int = 0 , var left: TreeNode? = null, var right: TreeNode? = null)
}