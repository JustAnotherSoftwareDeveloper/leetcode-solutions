//https://leetcode.com/problems/zigzag-conversion/
class ZigZagConversion {
    fun convert(s: String, numRows: Int) : String {
        val rowMap = mutableMapOf<Int,String>()
        var currRow = 0
        var goingDown = true
        if (numRows == 1) {
            return s
        }
        for(i in s.indices) {
            rowMap[currRow] = (rowMap[currRow] ?: "" ) +s[i]
            currRow += if (goingDown) 1 else -1
            if (currRow == 0) {
                goingDown = true
            }
            if (currRow == numRows-1) {
                goingDown = false
            }
        }
        var finalStr : String = ""
        for(i in 0 ..numRows) {
            finalStr+=(rowMap[i] ?: "")
        }
        return finalStr
    }
}