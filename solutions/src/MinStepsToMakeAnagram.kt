/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 */
class MinStepsToMakeAnagram {
    fun minSteps(s: String, t: String): Int {
        if (s.length != t.length) {
            return -1
        }
        val sMap = s.groupingBy { it }.eachCount().toMutableMap()
        val tMap = t.groupingBy { it }.eachCount().toMutableMap()

        s.forEach {
            val current = tMap.getOrDefault(it,0)
            if (current > 0) {
                tMap[it]=current-1
            }
        }
        t.forEach {
            val current = sMap.getOrDefault(it,0)
            if (current > 0) {
                sMap[it] = current-1
            }
        }

        return minOf(sMap.values.sum(),tMap.values.sum())
    }
}