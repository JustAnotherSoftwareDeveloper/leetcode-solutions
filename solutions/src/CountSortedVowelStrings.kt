/**
 * https://leetcode.com/problems/count-sorted-vowel-strings/
 */
class CountSortedVowelStrings {

    fun countVowelStrings(n: Int): Int {
        if (n == 1) {
            return 5
        }
        val vowelMap : MutableMap<Pair<Int,Char>,Int> = mutableMapOf()

        val vowels = mutableListOf('a','e','i','o','u')

        vowels.forEach { vowelMap[Pair(1,it)] = 1 }

        for (i in 1 until n) {
            for (v in vowels) {
                val current = vowelMap[Pair(i,v)]!!
                when (v)  {
                    'a' -> {
                        vowelMap[Pair(i+1,'a')] = vowelMap.getOrDefault(Pair(i+1,'a'),0)+current
                        vowelMap[Pair(i+1,'e')] = vowelMap.getOrDefault(Pair(i+1,'e'),0)+current
                        vowelMap[Pair(i+1,'i')] = vowelMap.getOrDefault(Pair(i+1,'i'),0)+current
                        vowelMap[Pair(i+1,'o')] = vowelMap.getOrDefault(Pair(i+1,'o'),0)+current
                        vowelMap[Pair(i+1,'u')] = vowelMap.getOrDefault(Pair(i+1,'u'),0)+current
                    }
                    'e' -> {
                        vowelMap[Pair(i+1,'e')] = vowelMap.getOrDefault(Pair(i+1,'e'),0)+current
                        vowelMap[Pair(i+1,'i')] = vowelMap.getOrDefault(Pair(i+1,'i'),0)+current
                        vowelMap[Pair(i+1,'o')] = vowelMap.getOrDefault(Pair(i+1,'o'),0)+current
                        vowelMap[Pair(i+1,'u')] = vowelMap.getOrDefault(Pair(i+1,'u'),0)+current
                    }
                    'i' -> {
                        vowelMap[Pair(i+1,'i')] = vowelMap.getOrDefault(Pair(i+1,'i'),0)+current
                        vowelMap[Pair(i+1,'o')] = vowelMap.getOrDefault(Pair(i+1,'o'),0)+current
                        vowelMap[Pair(i+1,'u')] = vowelMap.getOrDefault(Pair(i+1,'u'),0)+current
                    }
                    'o' -> {
                        vowelMap[Pair(i+1,'o')] = vowelMap.getOrDefault(Pair(i+1,'o'),0)+current
                        vowelMap[Pair(i+1,'u')] = vowelMap.getOrDefault(Pair(i+1,'u'),0)+current
                    }
                    'u' -> {
                        vowelMap[Pair(i+1,'u')] = vowelMap.getOrDefault(Pair(i+1,'u'),0)+current
                    }
                }

            }
        }

        var sum = 0
        for (v in vowels) {
            sum+= vowelMap[Pair(n,v)]!!
        }
        return sum

    }


}