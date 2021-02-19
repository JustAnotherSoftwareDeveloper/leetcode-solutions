/**
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 */
class TrimBinarySearchTree {

    fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? {
        return helper(root,low,high)
    }

    private fun helper(node: TreeNode?, low: Int, high: Int) : TreeNode? {
        if (node == null) {
            return null;
        }
        //Node is too small, use right subtree
        return when {
            node.`val` < low -> {
                helper(node.right,low, high)
            }
            else -> if (node.`val` > high) {
                helper(node.left,low,high)
            } else {
                node.left = helper(node.left,low,high)
                node.right = helper(node.right,low,high)
                node
            }
        }
    }
}