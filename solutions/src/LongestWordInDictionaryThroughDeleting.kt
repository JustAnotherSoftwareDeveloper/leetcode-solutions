import java.util.*
import kotlin.Comparator

class LongestWordInDictionaryThroughDeleting {
    fun findLongestWord(s: String, d: List<String>) : String {
        val sCompare = compareBy<String>{-it.length}.thenBy { it }

        val sortedDict = d.sortedWith(sCompare)
        for (i in sortedDict.indices) {
            if (fitsString(s,sortedDict[i])) {
                return sortedDict[i]
            }
        }
        return ""

    }

    fun fitsString(s: String, target: String) :Boolean {
        if (target == "") {
            return true
        }
        if (s == "") {
            return false
        }
        if (s[0] == target[0]) {
            return fitsString(s.substring(1),target.substring(1))
        }
        else {
            return fitsString(s.substring(1),target)
        }
    }


}