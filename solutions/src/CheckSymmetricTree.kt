import java.util.*

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
class CheckSymmetricTree {
    data class TreeLevelSide(val level: Int, val left: Boolean)
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        val treeMap: MutableMap<TreeLevelSide,MutableList<Int?>> = mutableMapOf()
        traverseTree(root.left,1,true,treeMap)
        traverseTree(root.right,1,false,treeMap)
        val listGroupings = treeMap.entries.groupBy { it.key.level }
        listGroupings.entries.forEach{
            val lists = it.value.map { e -> e.value }
            println("${it.key}: ${lists[0]} ${lists[1]}")
            if (lists[0] != lists[1].reversed()) {
                return false
            }
        }
        return true

    }

    private fun traverseTree(node: TreeNode?, level: Int, left: Boolean, treeMap:  MutableMap<TreeLevelSide,MutableList<Int?>>) {
        if (node == null) {
            treeMap.computeIfAbsent(TreeLevelSide(level,left)){ mutableListOf() }.add(null)
        }
        else {
            treeMap.computeIfAbsent(TreeLevelSide(level,left)){ mutableListOf() }.add(node.`val`)
            traverseTree(node.left,level+1,left,treeMap)
            traverseTree(node.right,level+1,left,treeMap)
        }

    }


}