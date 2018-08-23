

class ConstructBinaryTreeFromTraversals {
    data class TreeNode(var `val`:Int = 0, var left: TreeNode? = null, var right: TreeNode? = null)


    fun inOrderTraverse(n: TreeNode?) {
        if (n!==null) {
            inOrderTraverse(n.left)
            println(n.`val`)
            inOrderTraverse(n.right)
        }
    }
    fun constructFromPre(pre: IntArray): TreeNode? {
        if (pre.isEmpty()) {
            return null
        }
        val mid = TreeNode(pre[0])
        if (pre.size == 1) {
            return mid
        }
        var inflection = pre.size
        for (i in 1 until pre.size) {
            if (pre[i]>pre[0]) {
                inflection = i
                break
            }
        }
        val leftArr=pre.copyOfRange(1,inflection)
        val rightArr = pre.copyOfRange(inflection,pre.size)
        mid.left=constructFromPre(leftArr)
        mid.right=constructFromPre(rightArr)
        return mid
    }

}