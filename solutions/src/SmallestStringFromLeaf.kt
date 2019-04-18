import kotlin.math.min

//https://leetcode.com/problems/smallest-string-starting-from-leaf/

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class SmallestStringFromLeaf {

    companion object {
        val charMap: MutableMap<Int,Char> = mutableMapOf();
    }
    fun smallestFromLeaf(root: TreeNode?): String {


        "abcdefghijklmnopqrstuvwxyz".forEachIndexed { index, c -> charMap[index] = c }



        return traverse(root, "")
    }

     private fun traverse(t: TreeNode?, currString: String) : String {
        if (t == null ) {
            return ""
        }
         val newString =  charMap[t.`val`]!!.toString() + currString
         return if (t.left == null && t.right == null) {
             newString
         } else if (t.left == null && t.right != null) {
             traverse(t.right,newString)
         } else if (t.right == null && t.left != null) {
             traverse(t.left,newString)
         } else {
             val left = traverse(t.left,newString)
             val right = traverse(t.right, newString)
             if (left > right) {right} else {left}
         }
     }


     class TreeNode(var `val`: Int?) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


}

