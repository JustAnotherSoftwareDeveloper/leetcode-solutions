/**
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/
 */
class DeleteLeavesWithGivenValue {

    fun removeLeafNodes(root: TreeNode?, target: Int) : TreeNode? {
        val removeAll = removalTraverse(root,target);

        return if (removeAll) null else root
    }

    private fun removalTraverse(node: TreeNode? ,target: Int) : Boolean {
        if (node == null) {
            return true;
        }
        val removeLeft = removalTraverse(node.left,target)
        val removeRight = removalTraverse(node.right,target);
        if (removeLeft) {
            node.left = null;
        }
        if (removeRight) {
            node.right = null;
        }

        if (node.left == null && node.right == null && node.`val` == target) {
            return true;
        }
        return false;
    }
}