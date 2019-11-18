class ZigZagBinaryTree {

    fun zigzagLevelOrder(root: TreeNode?) : List<List<Int>> {
        val levels = mutableListOf<List<Int>>()
        var goLeft = true
        val levelMap = mutableMapOf<Int,List<Int>>()
        traverseTree(root,0,levelMap)
        var currentLevel = 0
        while (currentLevel < levelMap.size) {
            if (goLeft) {
                levels.add(levelMap[currentLevel]!!)
            }
            else {
                levels.add(levelMap[currentLevel]!!.reversed())
            }
            goLeft = !goLeft
            currentLevel++
        }
        return levels
    }

    private fun traverseTree(node: TreeNode?, level: Int, levelMap: MutableMap<Int,List<Int>> ) : Unit {
        if (node == null) {
            return
        }
        levelMap[level] = (levelMap[level] ?: mutableListOf() )+node.`val`
        traverseTree(node.left,level+1,levelMap)
        traverseTree(node.right,level+1,levelMap)
    }
}