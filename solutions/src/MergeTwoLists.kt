class MergeTwoLists {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?) : ListNode? {
        val root = ListNode(-1)
        var currNode = root
        var listOne = l1
        var listTwo = l2
        while (listOne != null || listTwo != null) {
            var newNode: ListNode
            when {
                listOne == null -> {
                    newNode = ListNode(listTwo!!.`val`)
                    listTwo = listTwo!!.next
                }
                listTwo == null -> {
                    newNode = ListNode(listOne.`val`)
                    listOne = listOne.next
                }
                listOne.`val` > listTwo.`val` -> {
                    newNode = ListNode(listTwo.`val`)
                    listTwo = listTwo.next
                }
                else -> {
                    newNode = ListNode(listOne.`val`)
                    listOne = listOne.next
                }
            }
            currNode.next = newNode
            currNode = newNode
        }
        return root.next
    }
}