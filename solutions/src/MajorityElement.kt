//https://leetcode.com/problems/majority-element/
class MajorityElement {

    fun majorityElement(nums: IntArray): Int {
        val numMap = mutableMapOf<Int,Int>()
        nums.forEach { value ->
            numMap[value] = numMap.getOrDefault(value,0)+1
        }
        numMap.forEach { (key, value) ->
            if (value > nums.size/2) {
                return key
            }
        }
        return -1
    }
}