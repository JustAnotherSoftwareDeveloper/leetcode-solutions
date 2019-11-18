class MinDominoRotations {
    fun minDominoRotations(A: IntArray, B: IntArray) : Int {
        for(i in 1..6) {
            var steps = 0
            val clonedArray = if (A.filter { i == it }.count() > B.filter { i == it }.count()) A.clone() else B.clone()
            val targetArray = if (A.filter { i == it }.count() > B.filter { i == it }.count()) B else A
            for (j in clonedArray.indices) {
                if (clonedArray[j] == i) {
                    continue
                }
                if (targetArray[j] == i ) {
                    clonedArray[j] = i
                    steps++
                }
            }
            if (clonedArray.all { it == i }) return steps
        }

        return -1
    }
}