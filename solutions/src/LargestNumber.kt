/**
 * https://leetcode.com/problems/largest-number/
 */
class LargestNumber {
    fun largestNumber(nums: IntArray) : String {
        if (nums.isEmpty()) {
            return ""
        }
        if (nums.all { it == 0 }) {
            return "0"
        }
        val strCompare = Comparator<String> { o1, o2 ->
            var s1 = o1+o2
            var s2 = o2+o1
            s2.compareTo(s1)
        }
        return nums.map  { it.toString() } .sortedWith(strCompare).joinToString(separator = "")

    }
}