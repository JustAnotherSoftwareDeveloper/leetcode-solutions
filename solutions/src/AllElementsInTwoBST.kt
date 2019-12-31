class AllElementsInTwoBST {
    fun getAllElements(root: TreeNode?, root2: TreeNode?) : List<Int> {
        val oneList = mutableListOf<Int>()
        val twoList = mutableListOf<Int>()
        listFromTree(root,oneList)
        listFromTree(root2,twoList)
        var i = 0;
        var j = 0
        var threeList = mutableListOf<Int>()
        while (i < oneList.size || j < twoList.size) {
            when {
                i >= oneList.size -> {
                    threeList.add(twoList[j])
                    j++
                }
                j >= twoList.size -> {
                    threeList.add(oneList[i])
                    i++
                }
                oneList[i] > twoList[j] -> {
                    threeList.add(twoList[j])
                    j++
                }
                else -> {
                    threeList.add(oneList[i])
                    i++
                }
            }
        }
        return threeList
    }

    private fun listFromTree(root: TreeNode?, list: MutableList<Int>) : Unit {
        if (root == null) {
            return
        }
        listFromTree(root.left,list)
        list.add(root.`val`)
        listFromTree(root.right,list)
    }


}