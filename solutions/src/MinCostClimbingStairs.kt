//https://leetcode.com/problems/min-cost-climbing-stairs/
class MinCostClimbingStairs {

    fun minCostClimbingStairs(cost: IntArray) : Int {
        var costArray = arrayOfNulls<Int>(cost.size+1)
        costArray.forEachIndexed{index, i ->
            if (index < 2) {
                costArray[index] = cost[index]

            }
            else {
                val baseCost = if (index < cost.size) cost[index] else 0
                val oneStepCost = baseCost + costArray[index - 1]!!
                val twoStepCost = baseCost + costArray[index-2]!!
                costArray[index] = if (oneStepCost>twoStepCost) twoStepCost else oneStepCost
            }

        }
        return costArray[costArray.lastIndex]!!

    }
}