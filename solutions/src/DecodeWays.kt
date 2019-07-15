//https://leetcode.com/problems/decode-ways/description/
class DecodeWays {


    fun numDecodings(s: String) : Int {
        if (s.isEmpty()) return 0

        val dynamicArray = IntArray(s.length+1)

        dynamicArray[0] = 1
        dynamicArray[1] = if (s[0] == '0') 0 else 1
        for (i in 2..s.length) {
            val first = s.substring(i-1,i).toInt()
            val second = s.substring(i-2,i).toInt()
            if (first in 1..9) {
                dynamicArray[i]+=dynamicArray[i-1]
            }
            if (second in 10..26) {
                dynamicArray[i]+=dynamicArray[i-2]
            }

        }

        return dynamicArray[s.length]


    }



}