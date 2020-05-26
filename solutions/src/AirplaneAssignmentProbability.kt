class AirplaneAssignmentProbability {
    fun nthPersonGetsNthSeat(n: Int) : Double {
        val dp = DoubleArray(n)
        dp[0] = 1.0
        for (i in 1 until dp.size) {
            dp[i] = 1.0/(i+1) + ((i+1-2.0)/(i+1))*dp[i-1];
        }
        return dp.last()
    }
}