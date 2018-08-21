import java.util.*
import kotlin.math.absoluteValue

class RandomPickWIthWeight(w: IntArray) {
    //https://leetcode.com/problems/random-pick-with-weight/description/
    private val indexedArr : IntArray
    private val totalSize: Int
    init {
        val indexedList: MutableList<Int> = mutableListOf()
        var total: Int = 0
        w.forEach {
            total += it
            indexedList.add(total)
        }
        indexedArr = indexedList.toIntArray()
        totalSize = total
    }

    fun pickIndex() : Int {

        val number = Random().nextInt(totalSize)
        val index = searchForCorrectIndex(0,indexedArr.size-1,number)
        return index
    }

    fun searchForCorrectIndex(start: Int, end: Int, value: Int) : Int {
        return when {
            start == end -> start
            end - start == 1 -> if (value >= indexedArr[start]) end else start
            else -> {
                val midIndex = start + (end - start)/2
                if (indexedArr[midIndex] >= value) {
                    searchForCorrectIndex(start,midIndex,value)
                } else {
                    searchForCorrectIndex(midIndex,end,value)
                }
            }
        }


    }
}