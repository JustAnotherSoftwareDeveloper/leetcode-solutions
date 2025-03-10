class RemoveDuplicatesFromSortedList {


    fun deleteDuplicates(head: ListNode?): ListNode? {
        val valuesEncountered = mutableSetOf<Int>()
        var current = head
        while (current != null) {
            valuesEncountered.add(current.`val`)
            var next = current.next
            while (next != null && valuesEncountered.contains(next.`val`)) {
                next = next.next
            }
            current.next = next
            current = next
        }
        return head
    }
}