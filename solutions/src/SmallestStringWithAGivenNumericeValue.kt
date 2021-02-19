/**
 * https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
 *
 * Got the complexity right (O(n)). Time limit is being exceeded because I made my
 * code clean instead of writing something like:
 *
 * public String getSmallestString(int n, int k) {
 *  k -= n;
 *  int numZ = k / 25, remain = k % 25, numA = n - numZ - (remain != 0 ? 1 : 0);
 *  }
 *
 *  It's really not fair that they want some shorthand instead of just accurate code
 */
class SmallestStringWithAGivenNumericeValue {
    fun getSmallestString(n: Int, k: Int): String {
        val stringMap = "abcdefghijklmnopqrstuvwxyz"

        val returnChars = mutableListOf<Int>()

        var currentK = k
        for (i in 1..n) {
            if (i == n) {
                returnChars.add(0,currentK)
                continue
            }
            val minFromHere = (n-i)+26
            currentK -= if  (currentK < minFromHere) {
                val currentIndex = currentK - (n-i)
                returnChars.add(0,currentIndex)
                currentIndex
            } else {
                returnChars.add(0,26)
                26
            }
        }

        return returnChars.map { stringMap[it-1] }.joinToString("")


    }
}