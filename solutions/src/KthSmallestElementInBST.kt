
/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
class KthSmallestElementInBST {

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var smallest = -1
        var operator = root!!
        for (i in 1..k) {
            smallest = findSmallest(operator)
            operator = removeSmallest(operator,null,operator) ?: TreeNode(-1)
        }
        return smallest
    }

    private fun findSmallest(node: TreeNode) : Int {
        if (node.left == null) {
            return node.`val`
        }
        else {
            return findSmallest(node.left!!)
        }
    }
    private fun removeSmallest(root: TreeNode, parent: TreeNode?, node: TreeNode) : TreeNode? {
        if (parent == null) {
            if (node.left == null) {
                return node.right
            }
            else {
                removeSmallest(root,node,node.left!!)
                return node
            }
        }
        else {
            if (node.left == null) {
                parent.left = node.right
                return root
            }
            else {
                removeSmallest(root,node,node.left!!)
                return root
            }
        }
    }

}