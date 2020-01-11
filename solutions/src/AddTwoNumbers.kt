class ListNode(var `val` : Int = 0) {
    var next: ListNode? = null
}
class AddTwoNumbers {

    fun addTwoNumbers(l1: ListNode? , l2: ListNode?): ListNode? {
            val seed = ListNode(-1)
            var iter = seed
            var el1 = l1
            var el2 = l2
            var carryBit = 0
            while (el1 != null || el2!= null) {
                var value : Int
                when {
                    el1 == null -> {
                        value = el2!!.`val` + carryBit
                        el2 = el2.next
                    }
                    el2 == null -> {
                        value = el1.`val` + carryBit
                        el1 = el1.next
                    }
                    else -> {
                        value = el1.`val` + el2.`val` + carryBit
                        el1 = el1.next
                        el2 = el2.next
                    }
                }
                iter.next = ListNode(value % 10)
                iter = iter.next!!
                carryBit=value/10
            }
            if (carryBit > 0) {
                iter.next = ListNode(1)
            }
            return seed.next
        }

    }
