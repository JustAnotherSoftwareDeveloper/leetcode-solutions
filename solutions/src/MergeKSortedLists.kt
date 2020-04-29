/**
 * https://leetcode.com/problems/merge-k-sorted-lists/submissions/
 */
class MergeKSortedLists {
    fun mergeKLists(list: Array<ListNode?>) : ListNode? {
        return when {
            list.isEmpty() -> {
                null
            }
            list.size == 1 -> {
                list[0]
            }
            else -> {
                list.toList().reduce { agg, listNode -> mergeTwoLists(agg,listNode) }
            }
        }
    }

    private fun mergeTwoLists(l1: ListNode? , l2: ListNode?) : ListNode? {
        val root = ListNode()
        var current = root;
        var l1Curr = l1;
        var l2Curr = l2
        while (l1Curr != null || l2Curr != null) {
            when {
                l1Curr == null -> {
                    current.next = ListNode(l2Curr!!.`val`);
                    current = current.next!!
                    l2Curr = l2Curr.next
                }
                l2Curr == null -> {
                    current.next = ListNode(l1Curr.`val`);
                    current = current.next!!
                    l1Curr = l1Curr.next
                }
                else -> {
                    if (l1Curr!!.`val` > l2Curr!!.`val`) {
                        current.next = ListNode(l2Curr.`val`)
                        l2Curr = l2Curr.next
                    }
                    else {
                        current.next = ListNode(l1Curr.`val`)
                        l1Curr = l1Curr.next
                    }
                    current = current.next!!
                }
            }
        }
        return root.next
    }
}