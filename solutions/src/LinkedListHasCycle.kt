/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
class LinkedListHasCycle {

    fun hasCycle(head: ListNode?) : Boolean {
        val visited = mutableSetOf<ListNode>()
        var current = head;
        while (current != null) {
            if (visited.contains(current)) {
                return true
            }
            visited.add(current)
            current = current.next
        }
        return false
    }
}