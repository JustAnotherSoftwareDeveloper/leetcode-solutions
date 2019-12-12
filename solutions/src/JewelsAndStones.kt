//https://leetcode.com/problems/jewels-and-stones/submissions/
class JewelsAndStones {
    fun numJewelsInStones(J: String, S: String) : Int {
        val jewels = J.toCharArray().toSet();
        val stonesByChar = S.toCharArray().toList().groupingBy { it }.eachCount()
        var total = 0
        jewels.forEach {
            total+=stonesByChar[it] ?: 0
        }
        return total
    }
}