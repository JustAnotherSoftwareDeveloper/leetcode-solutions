import java.util.*

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
class FindModeInBST {

    fun findMode(root: TreeNode?) : IntArray {
        val freqMap = TreeMap<Int,Int>()
        traverseTree(root,freqMap);
        return if (freqMap.isNotEmpty()) {
            val valuesByFreq = freqMap.entries.sortedByDescending { it.value }.map { Pair(it.key,it.value) }
            val returnList = mutableListOf(valuesByFreq[0].first)
            var pointer = 1;
            while (pointer < valuesByFreq.size && valuesByFreq[0].second == valuesByFreq[pointer].second) {
                returnList.add(valuesByFreq[pointer].first);
                pointer++;
            }
            returnList.toIntArray()
        }
        else {
            intArrayOf()
        }

    }


    private fun traverseTree(node: TreeNode?, freqMap: TreeMap<Int,Int>) {
        if (node == null) {
            return;
        }
        freqMap[node.`val`] = freqMap.getOrDefault(node.`val`,0)+1
        traverseTree(node.left,freqMap)
        traverseTree(node.right,freqMap)
    }
}