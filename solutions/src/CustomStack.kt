class CustomStack(val maxSize: Int) {

    private val internalList = mutableListOf<Int>()

    fun push(x: Int) {
        if (internalList.size < maxSize) {
            internalList.add(0,x);
        }
    }

    fun pop() : Int {
        return if (internalList.isNotEmpty()) internalList.removeAt(internalList.lastIndex) else -1;
    }

    fun increment(k: Int, `val`: Int) {
        for (i in 0 until minOf(k,internalList.size)) {
            internalList[i]+=`val`
        }
    }
}