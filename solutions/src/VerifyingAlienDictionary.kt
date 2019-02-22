//https://leetcode.com/problems/verifying-an-alien-dictionary/

class VerifyingAlienDictionary {


    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val alienComparator = genComparator(order)
        val originalOrder = words.toList()
        val sortedOrder = words.sortedWith(alienComparator)

        return originalOrder == sortedOrder

    }
    private fun genComparator(order: String) : Comparator<String> {
        val charByIndex: Map<Char,Int> = order.mapIndexed{index, c -> c to index }.toMap()
        return Comparator { p0, p1 ->
            // Not doing a number of checks since parameters indicate valid input
            val str1 = p0!!
            val str2  = p1!!
            var index = 0
            while (index < str1.length && index < str2.length) {
                var difference = charByIndex[str1[index]]!! - charByIndex[str2[index]]!!
                if (difference != 0) {
                    return@Comparator difference
                }
                index++
            }

            when {
                str1.length == str2.length -> 0
                str1.length > str2.length -> 1
                else -> -1
            }
        }
    }
}