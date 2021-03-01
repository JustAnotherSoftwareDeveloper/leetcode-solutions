/**
 * https://leetcode.com/problems/grumpy-bookstore-owner
 */
class GrumpyBookstoreOwner {

    fun maxSatisfied(customers: IntArray, grumpy: IntArray, X: Int): Int {
        val satisfiedByDefault = customers.filterIndexed { index, i -> grumpy[index] == 0 }.sum()
        if (X >= grumpy.size) {
            return customers.sum()
        }
        var currentIndex = 0
        var grumpyFlipped = 0
        var currentGrumpy = 0

        for (i in 0 until X) {
            if (grumpy[i] == 1) {
                grumpyFlipped+=customers[i]
            }
        }
        currentGrumpy = grumpyFlipped

        for (i in 1 until grumpy.size) {
            if (grumpy[i-1] == 1) {
                currentGrumpy-=customers[i-1]
            }
            if ((i+(X-1) < grumpy.size) && grumpy[i+X-1] == 1) {
                currentGrumpy+=customers[i+X-1]
            }
            grumpyFlipped = maxOf(currentGrumpy,grumpyFlipped)
        }

        return satisfiedByDefault+grumpyFlipped

    }
}