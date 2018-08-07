import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class LongestPalindrome {
    //https://leetcode.com/problems/longest-palindromic-substring/description/
    fun longestPalindrome(s: String): String {
        if (s == null || s.length <= 1) {
            return s
        }
        var start = 0
        var end = 0
        for(i in 0..s.length -1) {
            val indexPairs = longestPalindromeAroundChar(s,i)
            val length = indexPairs.first - indexPairs.second
            val currLength = end - start
            if (length > currLength) {
                start = indexPairs.second
                end = indexPairs.first
            }
        }
        return s.substring(start,end + 1)

    }

    fun computePairLength(pair: Pair<Int,Int>): Int {
        return pair.first - pair.second
    }
    fun longestPalindromeAroundChar(S: String, index: Int): Pair<Int,Int> {

        val repeatingPair = repeatingPalindrome(S,index)

        val standardPair = standardPalindrome(S,index,index)

        val standardPairEven = standardPalindrome(S,index,index+1)

        val sorter = TreeMap<Int,Pair<Int,Int>>(compareBy<Int>{it}.reversed())
        sorter[computePairLength(repeatingPair)]=repeatingPair
        sorter[computePairLength(standardPair)]=standardPair
        sorter[computePairLength(standardPairEven)]=standardPairEven


        return  sorter.getOrDefault(sorter.firstKey(),Pair(index,index))

    }

    fun repeatingPalindrome(S: String, index: Int): Pair<Int,Int> {
        val indexChar = S[index]
        var start = index
        var end = index
        while (start >= 0 && S[start]==indexChar) {
            start --
        }
        while (end < S.length && S[end]==indexChar) {
            end ++
        }
        return  Pair(end-1,start+1)
    }
    fun standardPalindrome(S: String, start: Int, end: Int ): Pair<Int,Int> {
        var start = start
        var end = end
        if (end >= S.length) {
            return Pair(start,start)
        }
        while (start >= 0 && end < S.length && S[start] == S[end]) {
            start --
            end ++
        }
        return Pair(end-1,start+1)
    }


}