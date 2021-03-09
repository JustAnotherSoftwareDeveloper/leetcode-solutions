import java.util.*
import kotlin.Comparator

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
class FindLargestValueInEachTreeRow {

    fun largestValues(root: TreeNode?) : List<Int> {
        val levelMap = mutableMapOf<Int,PriorityQueue<Int>>()
        val maxLevel = traverse(root,levelMap,0)
        if (maxLevel == -1) {
            return listOf()
        }
        val returnList = mutableListOf<Int>()
        for (i in 0..maxLevel) {
            returnList.add(levelMap[i]!!.peek())
        }
        return returnList
    }

    private fun traverse(node: TreeNode? , levelMap: MutableMap<Int,PriorityQueue<Int>>, level: Int) : Int {
        if (node == null) {
            return level-1;
        }
        val reverseComparator = Comparator<Int>{i1,i2 -> i2.compareTo(i1)}
        levelMap.computeIfAbsent(level){ PriorityQueue(reverseComparator) }.add(node.`val`)
        return maxOf(traverse(node.right,levelMap,level+1),traverse(node.left,levelMap,level+1))

    }
}