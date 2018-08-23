/**
 * Definition for a binary tree node.
 */
//https://leetcode.com/problems/binary-tree-pruning/description/
class Solution {

    data class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    fun pruneTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val leftPruned = pruneTree(root.left)
        val rightPruned = pruneTree(root.right)
        if (leftPruned == null && rightPruned == null && root.`val`==0) {
            return null
        }
        root.left = leftPruned
        root.right = rightPruned
        return root
    }
}