class BoatsToSavePeople {
    //https://leetcode.com/problems/boats-to-save-people/description/
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        //N Log(n)
        people.sort()
        // O(N)
        people.forEach { if (it > limit) throw Exception() }
        var numBoats = 0
        var lowerBound = 0
        var upperBound = people.size - 1
        while (upperBound > lowerBound) {
            val sumTwo = people[lowerBound] + people[upperBound]
            if (limit >= sumTwo) {
                lowerBound++
            }
            upperBound--
            numBoats++
        }
        if (upperBound == lowerBound) {
            numBoats++
        }
        return numBoats


    }
}