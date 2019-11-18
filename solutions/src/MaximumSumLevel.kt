//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
class MaximumSumLevel {

    fun maxLevelSum(root: TreeNode?) :Int {
        val sumMap = mutableMapOf<Int,Int>()
        var topVal = Int.MIN_VALUE
        var topLevel = 0
        traverse(root,sumMap,1)
        sumMap.keys.sorted().forEach {
            if (sumMap[it]!! > topVal) {
                topVal = sumMap[it]!!
                topLevel = it
            }
        }
        return topLevel
    }

    private fun traverse(node: TreeNode?, sumMap : MutableMap<Int,Int>, level: Int) {
        if (node == null) {
            return
        }
        sumMap[level] = (sumMap[level] ?: 0)+node.`val`
        traverse(node.left,sumMap,level+1)
        traverse(node.right,sumMap,level+1)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}