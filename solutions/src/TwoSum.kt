import java.util.*
import kotlin.collections.ArrayList

class TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val compliments = HashMap<Int,Int>()
        nums.forEachIndexed { index, i ->
            if (compliments.containsKey(i)) {
                return arrayListOf<Int>(compliments.getOrDefault(i,-1),index).toIntArray()
            }
            val compliment = target - i
            compliments.put(compliment, index)
        }
        throw Error("No Pair Found")

    }



}