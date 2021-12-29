class RomanToInteger {

    fun romanToInt(s: String): Int {
        val valueMapping = mapOf(Pair('I',1),Pair('V',5),Pair('X',10),Pair('L',50),Pair('C',100),Pair('D',500),Pair('M',1000))
        var totalVal = 0
        val stack = s.toMutableList();
        while (stack.isNotEmpty()) {
            val roman = stack.removeAt(0)
            if (stack.isNotEmpty()) {
                val next = stack[0]
                if (valueMapping[next]!! > valueMapping[roman]!!) {
                    val toAdd = valueMapping[next]!! - valueMapping[roman]!!
                    stack.removeAt(0)
                    totalVal+=toAdd
                    continue
                }
            }
            totalVal+=valueMapping[roman]!!
        }
        return totalVal
    }
}