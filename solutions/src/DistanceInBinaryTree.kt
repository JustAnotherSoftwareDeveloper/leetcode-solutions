class DistanceInBinaryTree {
    fun distanceK(root: TreeNode? , target: TreeNode?, K: Int) : List<Int> {
        if (root == null || target == null) {
            return listOf()
        }
        val distanceMap = mutableMapOf<Int,Int>()
        val distanceAtRoot = populateFromRoot(root,target.`val`,distanceMap)!!
        populateTargetChildren(target,distanceMap,0)
        populateTargetChildren(root,distanceMap,distanceAtRoot)
        return distanceMap.filter { it.value == K }.keys.toList()
    }

    private fun populateTargetChildren(node: TreeNode?, distanceMap: MutableMap<Int,Int>, currentDistance: Int) {
        if (node == null) {
            return
        }
        if (distanceMap[node.`val`] == null) {
            distanceMap[node.`val`] = currentDistance
        }
        populateTargetChildren(node.left,distanceMap,distanceMap[node.`val`]!!+1)
        populateTargetChildren(node.right,distanceMap,distanceMap[node.`val`]!!+1)
    }

    private fun populateFromRoot(node: TreeNode?, target: Int,distanceMap: MutableMap<Int, Int>) : Int? {
        if (node == null) {
            return null
        }
        if (node.`val` == target) {
            return 0
        }
        val distanceLeft = populateFromRoot(node.left,target,distanceMap)
        val distanceRight = populateFromRoot(node.right,target,distanceMap)
        val distance = when {
            distanceLeft == null && distanceRight == null -> null
            distanceLeft == null -> 1+distanceRight!!
            else -> 1+distanceLeft
        }
        if (distance != null) {
            distanceMap[node.`val`] = distance
        }
        return distance
    }
}