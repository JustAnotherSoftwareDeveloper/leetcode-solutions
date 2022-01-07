/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
 */
class BinaryTreeInOrderTraversal {

    fun inorderTraversal(root: TreeNode?) : List<Int> {
        if (root == null) {
            return listOf()
        }
        val returnlist = mutableListOf<Int>()
        returnlist.addAll(inorderTraversal(root.left))
        returnlist.add(root.`val`)
        returnlist.addAll(inorderTraversal(root.right))
        return returnlist
    }
}