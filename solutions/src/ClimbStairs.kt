//https://leetcode.com/problems/climbing-stairs/
class ClimbStairs {
    fun climbStairs(n: Int ) : Int {
        val stairs = arrayOfNulls<Int?>(n+1)
        when (n) {
            0 -> return 0
            1 -> return 1
            2 -> return 2
        }
        stairs[0] = 0
        stairs[1] = 1
        stairs[2] = 2

        var i = 3
        while (i < stairs.size) {
            var total = 0
            total+=stairs[i-1]!!;
            total+=stairs[i-2]!!
            stairs[i] = total
            i++
        }
        return stairs[n]!!;
    }
}