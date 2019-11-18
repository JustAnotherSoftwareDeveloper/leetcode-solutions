import java.util.*

class Find132Pattern {

    fun find132pattern(nums: IntArray) : Boolean {
        if (nums.size < 3) {
            return false
        }
        var min = nums[0]
        val numberToOccurances = TreeMap<Int,Int>()
        for (i in 1 until nums.size) {
            numberToOccurances[nums[i]] = (numberToOccurances[nums[i]] ?: 0)+1
        }
        for(i in 1 until nums.lastIndex) {
            numberToOccurances[nums[i]] = numberToOccurances[nums[i]]!! -1
            if (numberToOccurances[nums[i]] == 0) {
                numberToOccurances.remove(nums[i])
            }
            min = minOf(nums[i-1],min)
            val maxOfKey = numberToOccurances.floorKey(nums[i]-1)
            if (maxOfKey!= null && maxOfKey > min) {
                return true
            }

        }
        return false
    }
}