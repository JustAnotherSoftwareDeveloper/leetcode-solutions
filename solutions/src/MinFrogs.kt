/**
 * https://leetcode.com/problems/minimum-number-of-frogs-croaking/submissions/
 */
class MinFrogs {

    fun minNumberOfFrogs(croakOfFrogs: String) : Int {
        var totalFrogs = 0
        var frogsAvailable = 0
        var croakMap = mutableMapOf(Pair('c',0),Pair('r',0), Pair('o',0),Pair('a',0),Pair('k',0))
        for (c in croakOfFrogs) {
            if (c == 'c') {
                if (frogsAvailable == 0) {
                    totalFrogs++
                    frogsAvailable++
                }
                frogsAvailable--
                croakMap['c'] = croakMap['c']!!+1
                croakMap['k'] = croakMap['k']!!+1
            }
            if (c == 'r') {
                if (croakMap['c']!! < 1) {
                    return -1
                }
                croakMap['c'] = croakMap['c']!!-1
                croakMap['r'] = croakMap['r']!!+1
            }
            if (c == 'o') {
                if (croakMap['r']!! < 1) {
                    return -1
                }
                croakMap['r'] = croakMap['r']!!-1
                croakMap['o'] = croakMap['o']!!+1
            }
            if (c == 'a') {
                if (croakMap['o']!! < 1) {
                    return -1
                }
                croakMap['o'] = croakMap['o']!!-1
                croakMap['a'] = croakMap['a']!!+1
            }
            if (c == 'k') {
                if (croakMap['k']!! < 1) {
                    return -1
                }
                croakMap['a'] = croakMap['a']!!-1
                croakMap['k'] = croakMap['k']!!-1
                frogsAvailable++
            }
        }

        if (croakMap.values.any { it > 0 }) {
            return -1
        }
        return totalFrogs
    }


}