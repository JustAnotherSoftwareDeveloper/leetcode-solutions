
class BalanceBinaryTree {

    fun balanceBST(root: TreeNode?) : TreeNode? {
        val values = traverse(root);
        return buildBST(values);
    }

    private fun buildBST(values: List<Int>) : TreeNode? {
        if (values.isEmpty()) {
            return null;
        }
        val n = TreeNode();
        n.`val` = values[values.size/2];
        if (values.size/2 > 0) {
            val leftList = values.subList(0,values.size/2);
            println("Left List $leftList")
            n.left = buildBST(leftList);
        }
        if (values.size/2 + 1 < values.size) {
            val rightList = values.subList(values.size/2+1,values.size);
            println("Right List $rightList")
            n.right = buildBST(rightList)
        }

        return n;
    }


    private  fun traverse(node: TreeNode?) : List<Int> {
        return if (node == null) {
            listOf();
        }
        else {
            traverse(node.left)+ listOf(node.`val`)+traverse(node.right);
        }
    }
}