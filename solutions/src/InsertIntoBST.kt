class InsertIntoBST {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return TreeNode(`val`)
        }
        else if (root.`val` > `val`) {
            val leftNode = root.left
            if (leftNode != null) {
                insertIntoBST(leftNode,`val`)
            }
            else {
                root.left = TreeNode(`val`)
            }
        }
        else {
            val rightNode = root.right
            if (rightNode != null) {
                insertIntoBST(rightNode,`val`)
            }
            else {
                root.right = TreeNode(`val`)
            }
        }
        return root
    }

}