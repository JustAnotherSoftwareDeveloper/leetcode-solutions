/**
 * https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
 */
class NumberOfGoodNodePairs {

    fun countPairs(root: TreeNode?, distance: Int): Int {
        val pairs = mutableListOf<Pair<Int,Int>>()
        traverse(root,distance,pairs)
        return pairs.size
    }


    private fun traverse(node: TreeNode?, distance: Int, pairs: MutableList<Pair<Int,Int>>) : MutableMap<Int,MutableList<Int>> {

        if (node == null) {
            return mutableMapOf()
        }
        else if (node.left == null && node.right == null) {
            return mutableMapOf(Pair(1, mutableListOf(node.`val`)))
        }
        else if (node.right == null) {
            val traversal = traverse(node.left, distance, pairs)
            val newMap = mutableMapOf<Int, MutableList<Int>>()
            traversal.forEach { newMap[it.key + 1] = it.value }
            return newMap
        }
        else if (node.left == null) {
            val traversal = traverse(node.right, distance, pairs)
            val newMap = mutableMapOf<Int, MutableList<Int>>()
            traversal.forEach { newMap[it.key + 1] = it.value }
            return newMap
        } else {
            val traverseLeft = traverse(node.left, distance, pairs)
            val traverseRight = traverse(node.right, distance, pairs)
            traverseLeft.keys.forEach { lKey ->
                val validRightKeys = traverseRight.keys.filter { rKey -> lKey + rKey <= distance }
                val rightValues = mutableSetOf<Int>()
                validRightKeys.forEach { rKey -> rightValues.addAll(traverseRight[rKey]!!) }
                val leftValues = traverseLeft[lKey]!!
                leftValues.forEach { l ->
                    rightValues.forEach { r -> pairs.add(Pair(l, r)) }
                }
            }
            val newMap = mutableMapOf<Int, MutableList<Int>>()
            traverseLeft.forEach { newMap.computeIfAbsent(it.key + 1) { mutableListOf() }.addAll(it.value) }
            traverseRight.forEach { newMap.computeIfAbsent(it.key + 1) { mutableListOf() }.addAll(it.value) }
            return newMap
        }
    }

}