//https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
class NthNode {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeNthFromEnd(head: ListNode?, n: Int) : ListNode? {
        val nodes = mutableListOf<ListNode>()
        var current: ListNode? = head
        while (current!= null) {
            nodes.add(current)
            current = current.next
        }
        val toRemove = nodes.size - n
        if (nodes.size == 1) {
            return null
        }
        if (toRemove == 0) {
            return nodes[1]
        }
        if (toRemove == nodes.lastIndex) {
            nodes[nodes.lastIndex-1].next = null
        }
        else {
            nodes[toRemove-1].next = nodes[toRemove+1]
        }
        return head

    }


}