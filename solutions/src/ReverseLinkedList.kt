class ReverseLinkedList {

    fun reverseList(head: ListNode?) : ListNode? {
        if (head == null) {
            return null
        }
        val linkMaps = mutableMapOf<ListNode,ListNode>()
        var current = head!!
        while (current.next != null) {
            linkMaps[current.next!!] = current
            current = current.next!!
        }
        val newHead = current
        while (linkMaps[current] != null) {
            current.next = linkMaps[current]
            current = current.next!!
        }
        current.next = null
        return newHead
    }
}