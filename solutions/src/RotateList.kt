/**
 * https://leetcode.com/problems/rotate-list/
 */
class RotateList {
    fun rotateRight(head: ListNode?, k : Int) : ListNode? {
        if (head == null) {
            return null
        }
        if (head.next == null) {
            return head
        }
        var currHead = head
        var currTail = head
        var size = 1
        while (currTail!!.next != null) {
            size++
            currTail = currTail!!.next
        }
        currTail!!.next = currHead
        for (i in 0 until (size - (k % size))) {
            currTail = currTail!!.next
            currHead = currHead!!.next
        }
        currTail!!.next = null
        return currHead
    }
}