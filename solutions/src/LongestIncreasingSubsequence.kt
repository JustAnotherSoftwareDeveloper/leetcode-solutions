import java.util.*
import kotlin.math.max

//https://leetcode.com/problems/longest-increasing-subsequence/
class LongestIncreasingSubsequence {

    fun lengthOfLIS(nums: IntArray) : Int {
        val tails = IntArray(nums.size)
        var size = 0
        nums.forEach {
            var i = 0
            var j = size
            while (i != j) {
                val mid = (i+j)/2
                if (tails[mid] < it) {
                    i = mid+1
                }
                else {
                    j = mid
                }
            }
            tails[i] = it
            if (i == size) size++
        }
        return size
    }
}