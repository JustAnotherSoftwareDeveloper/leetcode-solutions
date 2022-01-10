/*
https://leetcode.com/problems/add-binary/
 */
class AddBinaryStrings {

    fun addBinary(a: String, b: String) : String {
        var aAdjusted = a.toList().toMutableList()
        var bAdjusted = b.toList().toMutableList()
        var maxLen = maxOf(a.length,b.length);
        for (i in 0 until maxLen - a.length) {
            aAdjusted.add(0,'0')
        }
        for (i in 0 until maxLen - b.length) {
            bAdjusted.add(0,'0')
        }
        var finalString = "";
        var carryBit = '0'
        for (i in 0 until maxLen) {
            val bits = listOf(carryBit,aAdjusted.removeAt(aAdjusted.lastIndex),bAdjusted.removeAt(bAdjusted.lastIndex));
            val bitCount = bits.count { it == '1' }
            if (bitCount == 0) {
                finalString = "0${finalString}"
                carryBit = '0'
            }
            else if (bitCount == 1) {
                finalString = "1${finalString}"
                carryBit = '0'
            }
            if (bitCount == 2) {
                finalString = "0${finalString}"
                carryBit = '1'
            }
            if (bitCount == 3) {
                finalString = "1$finalString"
                carryBit = '1'
            }
        }
        if (carryBit == '1') {
            finalString = "1$finalString"
        }
        return finalString;
    }
}