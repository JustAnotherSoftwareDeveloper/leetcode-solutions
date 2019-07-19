class CanIWinSol {
    private val map: MutableMap<Int, Boolean> = mutableMapOf()
    private var used: BooleanArray = BooleanArray(0)
    fun canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean {
        val sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2
        if (sum < desiredTotal) return false
        if (desiredTotal <= 0) return true

        map.clear()
        used = BooleanArray(maxChoosableInteger + 1)
        return helper(desiredTotal)
    }

    private fun helper(desiredTotal: Int): Boolean {
        if (desiredTotal <= 0) return false
        val key = format(used)
        if (!map.containsKey(key)) {
            // try every unchosen number as next step
            for (i in 1 until used.size) {
                if (!used[i]) {
                    used[i] = true
                    // check whether this lead to a win (i.e. the other player lose)
                    if (!helper(desiredTotal - i)) {
                        map[key] = true
                        used[i] = false
                        return true
                    }
                    used[i] = false
                }
            }
            map[key] = false
        }
        return map[key]!!
    }

    // transfer boolean[] to an Integer
    fun format(used: BooleanArray): Int {
        val binStr = used.map { if (it) "1" else "0" }.joinToString("")
        return Integer.parseInt(binStr,2)
    }
}

