import java.util.*
import java.util.stream.IntStream
import java.util.stream.Stream
/*
UNSOLVED
 */
class RandomWithBlacklist(val N: Int, val blacklist: IntArray) {
    //https://leetcode.com/problems/random-pick-with-blacklist/description/
    private val badNumbers : Set<Int> = blacklist.toSet()
    private val size = N - badNumbers.size
    private val rand = Random()
    fun pick(): Int {
        var randomNum : Int
        do {
            randomNum = rand.nextInt(N)
        } while (badNumbers.contains(randomNum))
        return randomNum
    }


}
