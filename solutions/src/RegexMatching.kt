/**
 * https://leetcode.com/problems/regular-expression-matching/
 */
class RegexMatching {
    fun isMatch(s: String, p: String) : Boolean {
        val dpArray = arrayOfNulls<Array<Boolean?>>(s.length+1)
        for (i in dpArray.indices) {
            dpArray[i] = arrayOfNulls(p.length+1)
        }
        for (i in dpArray.indices) {
            for( j in dpArray[0]!!.indices) {
                dpArray[i]!![j] = false
            }
        }
        dpArray[0]!![0] = true
        for(i in p.indices) {
            dpArray[0]!![i+1] = (p[i] == '*' && dpArray[0]!![i-1] == true)
        }
        for (i in s.indices) {
            for (j in p.indices) {
                if (p[j] == s[i] || p[j] == '.') {
                    dpArray[i+1]!![j+1] = dpArray[i]!![j]
                }
                if (p[j] == '*') {
                    if (p[j-1] != s[i] && p[j-1] != '.' ) {
                        dpArray[i+1]!![j+1] = dpArray[i+1]!![j-1]
                    }
                    else {
                        dpArray[i+1]!![j+1] = dpArray[i+1]!![j]!! ||  dpArray[i]!![j+1]!! || dpArray[i+1]!![j-1]!!
                    }
                }
            }

        }
        return dpArray[s.length]!![p.length]!!
    }




}