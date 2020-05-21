/**
 * https://leetcode.com/problems/simplified-fractions/
 */
class SimplifiedFraction {
    fun simplifiedFractions(n: Int) : List<String> {
        val possibleFractions = mutableListOf<Pair<Int,Int>>()
        for(i in 1 ..n) {
            for (j in 1 until i) {
                possibleFractions.add(Pair(j,i))
            }
        }
        return possibleFractions.filter { gcd(it.first,it.second) == 1 }.map { "${it.first}/${it.second}" }
    }

    private fun gcd(a: Int, b: Int) : Int {
        var intOne = a;
        var intTwo = b
        while(intOne % intTwo > 0) {
            val r = intOne % intTwo
            intOne = intTwo
            intTwo = r
        }
        return intTwo
    }
}