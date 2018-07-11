import kotlin.math.max

class LongestSubstring {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    fun lengthOfLongestSubstring(s: String) : Int {
        val chars = s.toCharArray()
        var subStringMap = HashMap<Char,Int>()
        var answer = 0
        var beginIndex = 0
        chars.forEachIndexed { index, c ->
            if (subStringMap.containsKey(c) && subStringMap.getValue(c) >= beginIndex) {
                beginIndex = subStringMap.getValue(c)+1
            }
            answer = max(answer , index - beginIndex + 1)
            subStringMap[c] = index
        }

        if (subStringMap.size == s.length) {
            return s.length
        }
        return answer
    }
}