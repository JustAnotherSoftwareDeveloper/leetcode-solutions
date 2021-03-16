class DeleteNodesAndReturnForest {

    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        val toDelete = to_delete.toSet()
        val forestMap = mutableMapOf<Int,TreeNode>()
        if (root != null) {
            forestMap[root.`val`] = root
        }
        traverse(null,root,forestMap,toDelete,DIRECTION.NONE)
        return forestMap.values.toList()
    }


    private fun traverse(parent: TreeNode?, node: TreeNode?, forest: MutableMap<Int,TreeNode>, toDelete: Set<Int>, direction: DIRECTION ) {
        if (node == null) {
            return
        }
        if (toDelete.contains(node.`val`)) {
            if (parent != null) {
                if (direction == DIRECTION.LEFT) {
                    parent.left = null
                }
                if (direction == DIRECTION.RIGHT) {
                    parent.right = null
                }

            }
            if (node.left != null) {
                forest[node.left!!.`val`] = node.left!!
            }
            if (node.right != null) {
                forest[node.right!!.`val`] = node.right!!
            }
            forest.remove(node.`val`)
        }

        traverse(node,node.left,forest,toDelete,DIRECTION.LEFT)
        traverse(node,node.right,forest,toDelete,DIRECTION.RIGHT)
    }


    private enum class DIRECTION {
        NONE,
        LEFT,
        RIGHT
    }
}