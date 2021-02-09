class CountTheArray {

    fun countArray(n: Int, k: Int, x: Int) : Long {
        val dpOne = LongArray(n+1)
        val dpOther = LongArray(n+1)
        dpOther[2] = 1
        dpOne[2] = 0
        for (i in 3..n) {
            dpOther[i] = dpOne[i-1] + (k-2) * dpOther[i-1];
            dpOne[i] = (k-1)*dpOther[i-1];
            val MOD = 1000000007;
            dpOther[i] = dpOther[i] % MOD
            dpOne[i] = dpOne[i] % MOD

        }

        return if (x == 1)dpOne[n] else dpOther[n]
    }
}