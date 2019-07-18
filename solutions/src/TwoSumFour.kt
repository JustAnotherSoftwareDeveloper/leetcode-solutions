//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
class TwoSumFour {
    class TreeNode(var `val`: Int, var left: TreeNode? , var right: TreeNode?)

    fun findTarget(root: TreeNode?, k: Int): Boolean {
        val allValues = mutableSetOf<Int>()
        traverse(root,allValues)
        return allValues.any {
            it != k/2 && allValues.contains(k-it)
        }
    }

    fun traverse(treeNode: TreeNode?, set: MutableSet<Int>) {
        if (treeNode == null) {
            return
        }
        set.add(treeNode.`val`)
        traverse(treeNode.left,set)
        traverse(treeNode.right,set)
    }
}