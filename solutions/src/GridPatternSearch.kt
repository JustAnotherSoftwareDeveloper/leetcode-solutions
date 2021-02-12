/**
 * https://www.hackerrank.com/challenges/the-grid-search/problem
 */
class GridPatternSearch {
    // Complete the gridSearch function below.
    fun gridSearch(G: Array<String>, P: Array<String>): String {
        if (P.size > G.size || P[0].length > G[0].length) {
            return "NO"
        }
        val gridSizeDifference = G.size - P.size
        val patternSizeDifference = G[0].length - P[0].length
        for (i in 0..gridSizeDifference) {
            val endIndex = i+P.lastIndex

            for(j in 0..patternSizeDifference) {
                var found = true
                var k = i
                while (k <= endIndex) {
                    val patternIndex = k-i
                    val gridSubstring = if (j+P[0].length > G[0].length) G[k].substring(j) else G[k].substring(j,P[0].length+j)
                    if (gridSubstring == P[patternIndex]) {
                        k++
                    }
                    else {
                        found = false
                        break
                    }
                }
                if (found) {
                    return "YES"
                }
            }

        }
        return "NO"

    }
}