/**
 * https://www.hackerrank.com/challenges/lilys-homework/problem
 */
class LilysHomework {

    fun lilysHomework(arr: Array<Int>): Int {


        return minOf(homework(arr.toMutableList()),homework(arr.toList().reversed().toMutableList())).toInt()

    }

    private fun homework(arr: MutableList<Int>) : Int {
        val positions = mutableMapOf<Int,Int>()
        for (i in arr.indices) {
            positions[arr[i]] = i
        }
        var count = 0
        val sorted = arr.sorted()
        for (i in arr.indices) {
            if (arr[i] != sorted[i]) {
                count++
                val newIndex = positions[sorted[i]]!!
                positions[arr[i]] = newIndex
                val tmp = arr[i]
                arr[i] = arr[newIndex]
                arr[newIndex] = tmp
            }
        }
        return count

    }

}