class MajorityElements {

    fun majorityElement(nums: IntArray) : Int {
        val elements = mutableMapOf<Int,Int>()
        nums.forEach {
            elements[it]= (elements[it] ?: 0)+1
        }
        return elements.entries.maxBy { it.value }!!.key
    }
}