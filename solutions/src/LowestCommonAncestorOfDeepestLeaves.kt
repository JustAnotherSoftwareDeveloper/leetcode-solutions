/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 */
class LowestCommonAncestorOfDeepestLeaves {

    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val traversal = traverse(root,0)
        return traversal.first
    }



    fun traverse(node: TreeNode? , depth: Int ) : Pair<TreeNode?,Int> {

        if (node == null) {
            return Pair(null,depth)
        }
        if (node.left == null && node.right == null) {
            return Pair(node,depth)
        }
        if (node.left == null ) {
            return traverse(node.right!!,depth+1)
        }
        if (node.right == null) {
            return traverse(node.left!!,depth+1)
        }
        else {
            val rightTraverse = traverse(node.right!!,depth+1)
            val leftTraverse = traverse(node.left!!,depth+1)
            if (rightTraverse.second > leftTraverse.second) {
                return rightTraverse
            }
            else if (leftTraverse.second > rightTraverse.second) {
                return leftTraverse
            }
            else {
                return Pair(node,leftTraverse.second)
            }
        }

    }
}