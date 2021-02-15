class LarrysArray {

    fun larrysArray(A: IntArray): String {
        var ret = 0
        for (i in A.indices) {
            for (j in i + 1 until A.size) {
                ret += if (A[i] > A[j]) 1 else 0
                ret %= 2
            }
        }
        return if (ret == 0) "YES" else "NO"
    }
}