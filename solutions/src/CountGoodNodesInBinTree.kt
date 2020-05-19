class CountGoodNodesInBinTree {

    fun goodNodes(root: TreeNode?) : Int {
        return traverseTree(root,root?.`val` ?: 0)
    }

    private fun traverseTree(node: TreeNode?, max: Int ) : Int {
        if (node == null) {
            return 0
        }
        val contribution = if (node.`val` >= max ) 1 else 0
        val newMax = maxOf(max,node.`val`)
        return contribution+traverseTree(node.left,newMax)+traverseTree(node.right,newMax)
    }
}