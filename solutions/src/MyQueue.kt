class MyQueue() {

    /** Initialize your data structure here. */
    var listReversed = mutableListOf<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        val newList = mutableListOf<Int>()
        newList.add(x)
        val tempList = mutableListOf<Int>()
        while(listReversed.isNotEmpty()) {
            tempList.add(listReversed.removeAt(listReversed.lastIndex))
        }
        while(tempList.isNotEmpty()) {
            newList.add(tempList.removeAt(tempList.lastIndex))
        }
        listReversed = newList
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        return listReversed.removeAt(listReversed.lastIndex)
    }

    /** Get the front element. */
    fun peek(): Int {
        return listReversed.last()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return listReversed.isEmpty()
    }

}