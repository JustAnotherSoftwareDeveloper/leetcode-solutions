//https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
class GroupThePeople {
    fun groupThePeople(groupSizes: IntArray) : List<List<Int>> {
        val groupSizeToId = mutableMapOf<Int,MutableList<Int>>()
        val allGroups = mutableListOf<List<Int>>()
        groupSizes.forEachIndexed { index, i ->
            groupSizeToId.getOrPut(i,{ mutableListOf()}).add(index)
        }
        groupSizeToId.forEach { entry ->
            var currList = mutableListOf<Int>()
            val maxSize = entry.key
            var currentSize = 0
            while (entry.value.isNotEmpty()) {
                currList.add(entry.value.removeAt(0));
                currentSize++
                if (currentSize == maxSize) {
                    currentSize = 0
                    allGroups.add(currList.toList())
                    currList = mutableListOf()
                }
            }
        }

        return allGroups
    }
}