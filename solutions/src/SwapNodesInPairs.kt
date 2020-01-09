class SwapNodesInPairs {
    fun swapPairs(head: ListNode? ) : ListNode? {
        val nodeList = mutableListOf<Int>()
        var currNode = head;
        while(currNode != null) {
            nodeList.add(currNode.`val`)
            currNode = currNode.next
        }
        for(i in 1 until nodeList.size step 2) {
            swap(i-1,i,nodeList)
        }
        val head = ListNode(-1)
        currNode = head
        nodeList.forEach {
            val node = ListNode(it)
            currNode!!.next = node
            currNode = node
        }
        return head.next
    }

    private fun swap(i: Int, j: Int, list: MutableList<Int>) {
        val temp = list[i]
        list[i] = list[j]
        list[j] = temp
    }



}