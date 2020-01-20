import java.util.*

class QueueReconstruction {

    fun reconstructQueue(people: Array<IntArray>) : Array<IntArray> {
        val dataItems = people.map { QueueItem(it[0],it[1]) }.sortedWith(compareByDescending<QueueItem>{it.height}.thenBy { it.peopleInFront }).toMutableList()
        val insertedList = mutableListOf<QueueItem>()
        while (dataItems.isNotEmpty()) {
            val toInsert = dataItems.filter { it == dataItems.maxBy { item -> item.height } }.sortedBy { it.peopleInFront }
            dataItems.removeAll(toInsert)
            toInsert.forEach {
                insertedList.add(it.peopleInFront,it)
            }
        }

        return insertedList.map { intArrayOf(it.height,it.peopleInFront) }.toTypedArray()
    }


    private data class QueueItem(val height: Int, val peopleInFront: Int)

}