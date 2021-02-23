/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 */
class ReturnLeftMostValue {


    fun findBottomLeftValue(root: TreeNode?): Int {
        val levelMap = mutableMapOf<Int,MutableList<Int>>()
        traverse(root,1,levelMap)
        val maxKey = levelMap.keys.max()!!

        return levelMap[maxKey]!![0]
    }

    fun traverse(node: TreeNode?, level: Int, map: MutableMap<Int,MutableList<Int>>) {
        if (node == null) {
            return;
        }
        map.computeIfAbsent(level) { mutableListOf()}.add(node.`val`)

        traverse(node.left,level+1,map)
        traverse(node.right,level+1,map);

    }


}