
import java.util.*

//https://leetcode.com/problems/validate-binary-search-tree/
class ValidateBinarySearchTree {
    var valid: Boolean = true
    fun isValidBST(root : TreeNode?) : Boolean {
        valid = true
        traverseTree(root)
        return valid
    }

    fun traverseTree(root: TreeNode?) : TreeSet<Int> {

        if (root == null) {
            return TreeSet()
        }
        val leftSet = traverseTree(root.left)
        val rightSet = traverseTree(root.right)

        if (leftSet.ceiling(root.`val`) != null) {
            valid = false
        }
        if (rightSet.floor(root.`val`) != null) {
            valid = false
        }
        val rootSet = TreeSet<Int>()
        rootSet.add(root.`val`)
        rootSet.addAll(leftSet)
        rootSet.addAll(rightSet)

        return rootSet
    }

    class TreeNode(var `val`:Int, var left: TreeNode? = null, var right: TreeNode? = null)
}