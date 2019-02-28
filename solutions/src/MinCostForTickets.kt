//https://leetcode.com/problems/minimum-cost-for-tickets/
class MinCostForTickets {

    fun mincostTickets(days: IntArray, costs: IntArray) : Int {
        val oneDayCost = costs[0]
        val sevenDayCost = costs[1]
        val thirtyDayCost = costs[2]


        val costOnDay = arrayOfNulls<Int>(days.size)

        var minCost = 0

        val reversedDays = days.reversed()
        reversedDays.forEachIndexed { index, i ->
            val oneDayCostForDay = calcCostOfIndex(index-1,costOnDay)+oneDayCost
            val sevenDayCostForDay = determineDayCost(sevenDayCost, reversedDays,costOnDay, index, 7)
            val thirtyDayCostForDay = determineDayCost(thirtyDayCost, reversedDays, costOnDay, index, 30)

           val costList = listOfNotNull(oneDayCostForDay,sevenDayCostForDay,thirtyDayCostForDay)


            minCost = costList.min()!!
            costOnDay[index] = minCost
        }
        return minCost

    }

    private fun determineDayCost(cost: Int, days: List<Int>, costsOnDay: Array<Int?>, index: Int, numDays: Int) : Int {


        var currIndex = index - 1
        while(currIndex >= 0 && days[currIndex] - days[index] < numDays) {
            currIndex--
        }
        return calcCostOfIndex(currIndex,costsOnDay)+cost
    }

    private fun calcCostOfIndex(index: Int, costsOnDay: Array<Int?>) : Int {
        return if (index >= 0) costsOnDay[index]!! else 0
    }
}