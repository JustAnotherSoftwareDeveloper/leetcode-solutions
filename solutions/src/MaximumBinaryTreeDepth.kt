/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
class MaximumBinaryTreeDepth {
    fun maxDepth(root: TreeNode?) : Int {
        return maxDepthHelper(root,1)
    }

    private fun maxDepthHelper(node: TreeNode?,level: Int) : Int {
        if (node == null) {
            return level-1
        }
        return maxOf(maxDepthHelper(node.left,level+1),maxDepthHelper(node.right,level+1))
    }

}