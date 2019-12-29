import java.util.*
//https://leetcode.com/problems/deepest-leaves-sum/
class DeepestLeavesSum {
    fun deepestLeavesSum(root: TreeNode?) : Int {
        val hierarchy = TreeMap<Int,MutableList<Int>>()
        hierarchy[0] = mutableListOf()
        traverse(root,1,hierarchy)
        return hierarchy.lastEntry().value.sum()
    }

    fun traverse(node: TreeNode?, level: Int, hierarchy: TreeMap<Int, MutableList<Int>>) {
        if (node == null) {
            return
        }
        hierarchy.computeIfAbsent(level) { mutableListOf()}.add(node.`val`)
        traverse(node.left,level+1,hierarchy)
        traverse(node.right,level+1,hierarchy)
    }
}