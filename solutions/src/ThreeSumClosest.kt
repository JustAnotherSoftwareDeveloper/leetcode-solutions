import kotlin.math.abs

class ThreeSumClosest {
    fun threeSumClosest(nums: IntArray, target: Int) : Int {
        //Assuming nums.size <= 3
        nums.sort()
        return nums.toList().mapIndexed { index, i ->
            var removedNums = nums.filterIndexed{ localIndex, _ -> localIndex != index}
            var returnVal = i + twoSumClosest(removedNums, target - i)
            returnVal
        }.minBy { abs(target - it) }!!
    }

    private fun twoSumClosest(nums: List<Int>, target: Int) : Int {
            //Assume Sorted List
            var start = 0
            var end  = nums.lastIndex
            var sum = nums[start]+nums[end]
            while (end > start) {
               var localSum = nums[start]+nums[end]
                sum = if (abs(target - sum) > abs(target - localSum)) localSum else sum
                if (localSum > target) {
                    end --
                }
                else {
                   start++
                }
            }
        return sum
    }
}