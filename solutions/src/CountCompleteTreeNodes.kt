import kotlin.math.pow

/**
 * LC Solution required shifting bits. I kinda gave up
 */
class CountCompleteTreeNodes {
    fun countNodes(root: TreeNode?) : Int {
        val numLevels = getNumLevels(root,0)
        if (numLevels == 0) {
            return 0
        }
        var totalNodes = 2.0.pow(numLevels-1).toInt()-1;
        var maxNodesAtLastLevel = 2.0.pow(numLevels-1).toInt();
        var numNodesMissing = getNodesMissing(root,0,numLevels);
        return if (numNodesMissing == 0) (2.0.pow(numLevels).toInt() -1) else totalNodes+(maxNodesAtLastLevel-numNodesMissing);

    }

    fun getNumLevels(root: TreeNode?, levels : Int) : Int {
        return if (root==null) {
            levels;
        }
        else {
            getNumLevels(root.left,levels+1);
        }
    }
    fun getNodesMissing(node: TreeNode?,level: Int, maxLevel: Int) : Int {
        if (level == maxLevel) {
            return 0
        }
        if (node == null) {
            return 1
        }
        val leftSearch = getNumLevels(node.left,1)
        val rightSearch = getNumLevels(node.right,1)
        if (leftSearch < (maxLevel - level)) {
            return 2.0.pow(level).toInt()
        }
        if (leftSearch == rightSearch) {
            return getNodesMissing(node.right,level+1,maxLevel)
        }
        else {
            return getNodesMissing(node.left,level+1,maxLevel)+getNodesMissing(node.right,level+1,maxLevel)
        }
    }
}