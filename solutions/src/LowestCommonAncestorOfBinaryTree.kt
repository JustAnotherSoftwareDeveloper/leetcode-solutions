/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
class LowestCommonAncestorOfBinaryTree {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode? , q: TreeNode?) : TreeNode? {
        return findAncestor(root!!,p!!.`val`,q!!.`val`)
    }

    private fun findAncestor(node: TreeNode, t1: Int, t2: Int) : TreeNode {
        val t1ExistsLeft = binarySearch(node.left,t1)
        val t2ExistsLeft = binarySearch(node.left,t2)
        val t1ExistsRight = binarySearch(node.right,t1)
        val t2ExistsRight = binarySearch(node.right,t2)
        if (t1ExistsLeft && t2ExistsLeft) {
            return findAncestor(node.left!!,t1,t2)
        }
        else if (t2ExistsRight && t1ExistsRight) {
            return findAncestor(node.right!!,t1,t2)
        }
        else {
            return node
        }
    }
    private fun binarySearch(node: TreeNode?, target: Int) : Boolean {
        if (node == null) {
            return false
        }
        if (node.`val` == target) {
            return true
        }
        else {
            return binarySearch(node.left,target) || binarySearch(node.right,target)
        }
    }
}