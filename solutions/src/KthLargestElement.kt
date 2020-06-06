/**
 * Looked up solution
 *
 */
class KthLargestElement {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        var k = k
        k = nums.size - k
        var lo = 0
        var hi = nums.size - 1
        while (lo < hi) {
            val j = partition(nums, lo, hi)
            if (j < k) {
                lo = j + 1
            } else if (j > k) {
                hi = j - 1
            } else {
                break
            }
        }
        return nums[k]
    }

    private fun partition(a: IntArray, lo: Int, hi: Int): Int {
        var i = lo
        var j = hi + 1
        while (true) {
            while (i < hi && a[++i] < a[lo]);
            while (j > lo && a[lo] < a[--j]);
            if (i >= j) {
                break
            }
            exch(a, i, j)
        }
        exch(a, lo, j)
        return j
    }

    private fun exch(a: IntArray, i: Int, j: Int) {
        val tmp = a[i]
        a[i] = a[j]
        a[j] = tmp
    }

}