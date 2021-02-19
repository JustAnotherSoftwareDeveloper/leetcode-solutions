/**
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 *
 * Copied Answer. Hate these BS Gotchas
 */
class MiniumSwapToMakeStringsEqual {
    fun minimumSwap(s1: String, s2: String): Int {
        var x1 = 0 // number of 'x' in s1 (skip equal chars at same index)
        var y1 = 0 // number of 'y' in s1 (skip equal chars at same index)
        var x2 = 0 // number of 'x' in s2 (skip equal chars at same index)
        var y2 = 0 // number of 'y' in s2 (skip equal chars at same index)
        for (i in 0 until s1.length) {
            val c1 = s1[i]
            val c2 = s2[i]
            if (c1 == c2) { // skip chars that are equal at the same index in s1 and s2
                continue
            }
            if (c1 == 'x') {
                x1++
            } else {
                y1++
            }
            if (c2 == 'x') {
                x2++
            } else {
                y2++
            }
        } // end for

        // After skip "c1 == c2", check the number of  'x' and 'y' left in s1 and s2.
        return if ((x1 + x2) % 2 != 0 || (y1 + y2) % 2 != 0) {
            -1 // if number of 'x' or 'y' is odd, we can not make s1 equals to s2
        } else x1 / 2 + y1 / 2 + x1 % 2 * 2
        // Cases to do 1 swap:
        // "xx" => x1 / 2 => how many pairs of 'x' we have ?
        // "yy" => y1 / 2 => how many pairs of 'y' we have ?
        //
        // Cases to do 2 swaps:
        // "xy" or "yx" =>  x1 % 2
    }
}