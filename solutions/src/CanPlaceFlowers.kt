/**
 * https://leetcode.com/problems/can-place-flowers/
 */
class CanPlaceFlowers {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var count = 0
        var i = 0
        while (i < flowerbed.size && count < n) {
            if (flowerbed[i] == 0) {
                //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0.
                val next = if (i == flowerbed.size - 1) 0 else flowerbed[i + 1]
                val prev = if (i == 0) 0 else flowerbed[i - 1]
                if (next == 0 && prev == 0) {
                    flowerbed[i] = 1
                    count++
                }
            }
            i++
        }
        return count == n
    }
}