class SamAndSubstrings {

    fun substrings(n: String) : Int {
        var res : Long = 0
        var frequency: Long = 1
        val MOD = (Math.pow(10.0,9.0)+7).toInt()
        for (i in n.length-1 downTo 0) {
            res  = (res+ Integer.valueOf("${n[i]}") * frequency * (i + 1) )% MOD
            frequency = (frequency*10+1) % MOD
        }
        return res.toInt()


    }
}