class FairCandySwap {

    fun fairCandySwap(A: IntArray, B: IntArray) : IntArray {
        val SumA = A.sum();
        val SumB = B.sum();

        val delta = (SumB - SumA)/2;

        val bSet = B.toSet();

        A.forEach {
            if (bSet.contains(it+delta)) {
                return intArrayOf(it,it+delta)
            }
        }

        return intArrayOf();
    }
}