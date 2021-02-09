/**
 * https://leetcode.com/problems/jump-game-iii
 */
class JumpGameIII {

    fun canReach(arr: IntArray, start: Int) : Boolean {
        var visitedIndex = mutableSetOf<Int>();
        var queue = mutableListOf(start)
        while (queue.isNotEmpty()) {
            val index = queue.removeAt(0);
            if (index >= 0 && index < arr.size && !visitedIndex.contains(index)) {
                visitedIndex.add(index)
                if (arr[index] == 0) {
                    return true;
                }
                queue.add(index+arr[index]);
                queue.add(index-arr[index]);
            }
        }

        return false;
    }
}