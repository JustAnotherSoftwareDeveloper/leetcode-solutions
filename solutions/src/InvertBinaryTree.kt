/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
class InvertBinaryTree {

    fun invertTree(root: TreeNode?): TreeNode? {
        traverseTree(root)
        return root
    }

    private fun traverseTree(node: TreeNode?) {
        if (node == null) {
            return
        }
        val left = node.left
        val right = node.right
        node.left = right
        node.right = left
        traverseTree(node.left)
        traverseTree(node.right)
    }
}