/*
https://leetcode.com/problems/longest-common-prefix/
 */
class LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>) : String {
        var prefix = ""
        if (strs.isNotEmpty()) {
            while (strs[0].isNotEmpty()) {
                val currentPrefix = strs[0][0];
                for (i in 1 until strs.size) {
                    if (strs[i].isEmpty()) {
                        return prefix
                    }
                    if (strs[i][0] != currentPrefix) {
                        return prefix
                    }
                }
                for (i in strs.indices) {
                    strs[i] = strs[i].substring(1)
                }
                prefix+=currentPrefix
            }
        }
        return prefix
    }
}