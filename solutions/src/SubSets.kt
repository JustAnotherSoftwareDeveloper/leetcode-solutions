/**
 * https://leetcode.com/problems/subsets/
 */
class SubSets {

    fun subSets(nums: IntArray) : List<List<Int>> {
        return subsetHelper(nums.toList())
    }

    private fun subsetHelper(nums: List<Int>) : List<List<Int>> {
        return if (nums.isEmpty()) {
            listOf(listOf())
        }
        else {

            val powerSet = mutableListOf<List<Int>>()
            val newList = nums.toMutableList()
            val top = newList.removeAt(0)
            val powerSetWthout = subsetHelper(newList)
            powerSet.addAll(powerSetWthout)
            powerSetWthout.forEach {
                powerSet.add(it+top)
            }
            powerSet
        }

    }
}