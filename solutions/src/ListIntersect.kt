/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
class ListIntersect {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
            val pointers = mutableMapOf<ListNode,Int>()
            if (headA == headB) {
                return headA
            }
            if (headA == null || headB == null) {
                return null
            }
            pointers[headA] = 1
            pointers[headB] = 1
            traverse(headA,pointers)
            traverse(headB,pointers)
            return pointers.entries.filter { it.value > 1 }.map { it.key }.lastOrNull()

    }


    private fun traverse(node: ListNode?, pointers: MutableMap<ListNode,Int>) {
        var current = node
        while (current?.next != null) {
            pointers[current.next!!] = pointers.getOrDefault(current.next!!,0)+1
            current = current.next
        }
    }
}