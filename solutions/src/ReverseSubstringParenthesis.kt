import java.util.*
import kotlin.Comparator

/**
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */
class ReverseSubstringParenthesis {


    fun reverseParentheses(s: String): String {


        val parensMap = mutableMapOf<Int,Int>()
        val pairList = mutableListOf<Pair<Int,Int>>()
        var currentOpenIndicies = mutableListOf<Int>()
        for (i in s.indices) {

            if (s[i] == '(') {
                currentOpenIndicies.add(i)

            }
            if (s[i] == ')') {
                pairList.add(Pair(currentOpenIndicies.removeAt(currentOpenIndicies.lastIndex),i))
            }
        }

        var modifiedS = s

        for (pair in pairList) {
            val beforeString = if (pair.first > 0) {
                modifiedS.substring(0,pair.first)
            }
            else {
                ""
            }
            val reversedString = modifiedS.substring(pair.first,pair.second+1).reversed()
            val afterString = if (pair.second < modifiedS.lastIndex) {
                modifiedS.substring(pair.second+1)
            }
            else {
                ""
            }
            modifiedS = beforeString+reversedString+afterString
        }


        modifiedS = modifiedS.filter { it != ')' && it != '(' }



        return modifiedS

    }

}