/**
 * https://leetcode.com/problems/similar-string-groups/
 */
class SimilarStringGroups {
    fun numSimilarGroups(A: Array<String>) :Int {
        if (A.size < 2) {
            return A.size
        }
        var groups = 0
        val aList : MutableList<String?> = A.toMutableList()
        for (i in aList.indices) {
            if (aList[i] != null) {
                val newStrings = aList[i]
                aList[i] = null
                groups++
                dfs(aList,newStrings)
            }
        }
        return groups
    }

    private fun dfs(arr: MutableList<String?>, str: String?) {
        for (i in arr.indices) {
            if (arr[i] == null) continue
            if (helper(str, arr[i])) { // both string str and arr[i] belong in same group
                val s = arr[i]
                arr[i] = null
                dfs(arr, s)
            }
        }
    }

    private fun helper(s: String?, t: String?): Boolean {
        var res = 0
        var i = 0
        while (res <= 2 && i < s!!.length) {
            if (s[i] != t!![i]) res++
            i++
        }
        return res == 2 || res == 0
    }

}