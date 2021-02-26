/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 */
class MostFrequentSubtreeSum {

    fun findFrequentTreeSum(root: TreeNode?): IntArray {

        val sumMap = mutableMapOf<Int,Int>()
        val sumFreq = mutableMapOf<Int,MutableList<Int>>()

        traverse(root,sumMap)

        var max = 0
        for (entry in sumMap.entries) {
            sumFreq.computeIfAbsent(entry.value) { mutableListOf()}.add(entry.key)
            max = maxOf(max,entry.value)
        }

        return sumFreq.getOrDefault(max, mutableListOf()).toIntArray()


    }


    fun traverse(node: TreeNode?, sumMap: MutableMap<Int,Int>) : Int {
        if (node == null) {
            return 0
        }
        val leftSum = traverse(node.left,sumMap)
        val rightSum = traverse(node.right,sumMap)
        val totalSum = node.`val`+leftSum+rightSum

        sumMap[totalSum] = sumMap.getOrDefault(totalSum,0)+1

        return totalSum
    }
}