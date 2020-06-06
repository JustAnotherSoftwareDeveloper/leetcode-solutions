import java.util.*


/**
 * https://leetcode.com/problems/combination-sum-iii/
 * cheated, for no reason because the answer was as complex as I was
 */
class CobinationSumThree {
    fun combinationSum3(k: Int, n: Int): List<List<Int>>? {
        val num = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val result: MutableList<List<Int>> = ArrayList()
        helper(result, ArrayList(), num, k, n, 0)
        return result
    }

    private fun helper(result: MutableList<List<Int>>, list: MutableList<Int>, num: IntArray, k: Int, target: Int, start: Int) {
        if (k == 0 && target == 0) {
            result.add(ArrayList(list))
        } else {
            var i = start
            while (i < num.size && target > 0 && k > 0) {
                list.add(num[i])
                helper(result, list, num, k - 1, target - num[i], i + 1)
                list.removeAt(list.size - 1)
                i++
            }
        }
    }
}