import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main(args: Array<String>) {
    println(measureTime {
        val tester = PalindromLinkedList()




        val result = listOf(
            tester.isPalindrome(ListNode(1,ListNode(2,ListNode(2,ListNode(1))))),
            tester.isPalindrome(ListNode(1,ListNode(2))),
           tester.isPalindrome(ListNode(1,ListNode(2,ListNode(3,ListNode(4,ListNode(5)))))),
            tester.isPalindrome(ListNode(1,ListNode(1))),
            tester.isPalindrome(ListNode(1,ListNode(2,ListNode(1))))
        )
        println(result)

    })

}





