class AddOneRowToTree {


    class TreeNode(var `val`: Int, var left: TreeNode? = null , var right : TreeNode? = null)

    fun addOneRow(root: TreeNode?, v: Int, d: Int): TreeNode? {
        if (d == 1) {
            val newRoot = TreeNode(v)
            newRoot.left = root
            return newRoot
        }
        val parents = findParents(root,1,d-1)
        parents.forEach{
            val leftSubTree = it.left
            val rightSubtree = it.right
            it.left = TreeNode(v)
            it.right = TreeNode(v)
            it.left!!.left = leftSubTree
            it.right!!.right = rightSubtree

        }
        return root
    }

    private fun findParents(node: TreeNode?, depth: Int, target: Int) : Set<TreeNode> {
        return when {
            node == null -> setOf()
            depth == target -> setOf(node)
            else -> {
                val returnSet = mutableSetOf<TreeNode>()
                returnSet.addAll(findParents(node.left, depth+1,target))
                returnSet.addAll(findParents(node.right,depth+1,target))
                returnSet
            }
        }
    }
}