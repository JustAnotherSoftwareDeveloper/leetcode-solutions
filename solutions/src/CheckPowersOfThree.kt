/**
 * https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 */
class CheckPowersOfThree {

    fun checkPowersOfThree(n: Int): Boolean {
        var number = n
        while (number >0) {
            if (number % 3 == 2) {
                return false
            }
            else {
                number/=3
            }
        }
        return true
    }
}