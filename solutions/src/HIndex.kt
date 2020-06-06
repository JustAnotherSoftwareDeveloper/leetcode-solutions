import java.util.*

/**
 * https://leetcode.com/problems/h-index/
 */
class HIndex {
    fun hIndex(citations: IntArray): Int {
       val citationsSize = citations.size
        val count = IntArray(citationsSize+1)
        citations.forEach {
            if (it > citationsSize) {
                count[citationsSize]++
            }
            else count[it]++
        }
        var total = 0
        for(i in citationsSize downTo 0) {
            total+=count[i]
            if (total >= i) {
                return i
            }
        }
        return 0
    }
}