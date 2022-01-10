import kotlin.math.ceil

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
class PalindromLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) {
            return true
        }
        var reversed : ListNode? = null
        var current = head
        while (current != null) {
            val newNode = ListNode(current.`val`)
            newNode.next = reversed
            reversed = newNode
            current = current.next
        }
        current = head
        while (current != null && reversed != null) {
            if (current.`val` != reversed.`val`) {
                return false
            }
            current = current.next
            reversed = reversed.next
        }
        return true

    }
}