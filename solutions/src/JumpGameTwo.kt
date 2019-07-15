import java.util.*
import kotlin.math.max
import kotlin.math.min

//https://leetcode.com/problems/jump-game-ii/description/
class JumpGameTwo  {

    fun jump(nums: IntArray) : Int {
        var numJumps = 0
        var currentEnd = 0
        var currentFarthest = 0
        for (i in 0 until nums.lastIndex) {
            currentFarthest = max(currentFarthest, i + nums[i])
            if (i == currentEnd) {
                numJumps++
                currentEnd = currentFarthest
            }
        }
        return numJumps
    }





}