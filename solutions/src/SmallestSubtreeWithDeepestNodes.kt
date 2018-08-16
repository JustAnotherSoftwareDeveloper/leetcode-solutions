import kotlin.math.max

class SmallestSubtreeWithDeepestNodes {
    //https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
    data class NodeWithDepth(val node: TreeNode? , val depth: Int)
    fun subtreeWithAllDeepest(root: TreeNode?) : TreeNode? { //O(nLog(n))
        return depthFirstSearch(root).node

    }

    fun depthFirstSearch(node: TreeNode?): NodeWithDepth {
        if (node == null) {
            return NodeWithDepth(null,0)
        }
        val left = depthFirstSearch(node.left)
        val right = depthFirstSearch(node.right)
        return when {
            left.depth > right.depth -> NodeWithDepth(left.node,left.depth+1)
            right.depth > left.depth -> NodeWithDepth(right.node, right.depth+1)
            else -> NodeWithDepth(node, right.depth+1)
        }
    }
}