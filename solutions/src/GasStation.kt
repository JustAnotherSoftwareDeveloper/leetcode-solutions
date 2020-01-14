class GasStation {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray) : Int {

        var start = gas.lastIndex
        var end = 0
        var sum = gas[start] - cost[start]
        while (start > end) {
            if (sum >=0) {
                sum += gas[end] - cost[end]
                end++
            }
            else {
                start--
                sum+= gas[start]-cost[start]
            }
        }
        return if (sum >= 0) start else -1
    }
}