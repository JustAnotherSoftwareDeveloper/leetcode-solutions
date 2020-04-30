
import java.util.*


/**
 * https://leetcode.com/problems/combinations/
 */
class Combinations {

    fun combine(n: Int, k: Int): List<List<Int>>? {
        val combs: MutableList<List<Int>> = mutableListOf()
        combineHelper(combs, mutableListOf(), 1, n, k)
        return combs
    }

    private fun combineHelper(combs: MutableList<List<Int>>, comb: MutableList<Int>, start: Int, n: Int, k: Int) {
        if (k == 0) {
            combs.add(comb.toList())
            return
        }
        for (i in start..n) {
            comb.add(i)
            combineHelper(combs, comb, i + 1, n, k - 1)
            comb.removeAt(comb.size - 1)
        }
    }

}