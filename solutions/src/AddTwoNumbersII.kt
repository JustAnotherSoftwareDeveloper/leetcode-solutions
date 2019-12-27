import java.math.BigInteger
import kotlin.math.pow

class AddTwoNumbersII {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?) : ListNode? {
        var l1Size = 0
        var l2Size = 0
        var l1Curr = l1
        var l2Curr = l2
        while (l1Curr != null) {
            l1Size++
            l1Curr = l1Curr.next
        }
        while (l2Curr != null) {
            l2Size++
            l2Curr = l2Curr.next
        }

        if (l1Size == 0 && l2Size == 0) {
            return null
        }
        var currentPower = maxOf(l1Size-1,l2Size-1)
        var currentMultiplier = 10.toDouble().pow(currentPower).toBigDecimal().toBigInteger()

        var addedNum = BigInteger.ZERO
        l1Curr = l1
        l2Curr = l2
        for(i in maxOf(l1Size,l2Size) downTo 1) {
            if (l1Size >= i) {
                addedNum+=(currentMultiplier.multiply(l1Curr!!.`val`.toBigInteger()))
                l1Curr = l1Curr.next
            }
            if (l2Size >= i) {
                addedNum+=(currentMultiplier.multiply(l2Curr!!.`val`.toBigInteger()))
                l2Curr = l2Curr.next
            }
            currentMultiplier = currentMultiplier.divide(BigInteger.TEN)
        }

        return buildListNode(addedNum)
    }

    private fun buildListNode(number: BigInteger) : ListNode? {
        val root = ListNode(-1)
        var curr = root
        number.toString().toCharArray().forEach {
            val n = ListNode(it.toString().toInt())
            curr.next = n
            curr = n

        }
        return root.next
    }
    class ListNode(var `val`: Int, var next: ListNode? = null)
}