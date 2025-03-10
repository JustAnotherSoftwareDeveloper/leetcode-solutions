class LongestSubstring2025 {

    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val charIndex = mutableMapOf<Char,Int>()
        var currentIndex = 0
        var startIndex = 0
        var longest = 0
        s.forEach {

            if ((charIndex[it] ?: -1) >= startIndex) {
                startIndex = charIndex[it]!! + 1
            }
            longest = maxOf(longest,1 + currentIndex - startIndex)
            charIndex[it] = currentIndex
            currentIndex++
        }
        return longest
    }
}