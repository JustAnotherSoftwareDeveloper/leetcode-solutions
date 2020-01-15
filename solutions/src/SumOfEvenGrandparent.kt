class SumOfEvenGrandparent {

    fun sumEvenGrandparent(root: TreeNode?): Int {
        return traverse(root,false,false)
    }


    private fun traverse(node: TreeNode?, parent: Boolean, grandparent: Boolean) : Int {
        if (node == null) {
            return 0
        }
        var sum = if (grandparent) node.`val` else 0

        val isEven = node.`val` % 2 == 0

        sum+=traverse(node.right,isEven,parent)
        sum+=traverse(node.left,isEven,parent)

        return sum

    }
}