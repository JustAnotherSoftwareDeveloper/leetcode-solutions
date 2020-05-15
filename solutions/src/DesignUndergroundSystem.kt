/**
 * https://leetcode.com/problems/design-underground-system/
 */
class DesignUndergroundSystem {

    private val totalTimes : MutableMap<Pair<String,String>, Int> = mutableMapOf()
    private val trips : MutableMap<Pair<String,String>,Int> = mutableMapOf()
    private val passengerStartLocation : MutableMap<Int,String> = mutableMapOf()
    private val passengerStartTimes : MutableMap<Int,Int> = mutableMapOf()

    fun checkIn(id: Int, stationName: String, t: Int) {
        passengerStartLocation[id] = stationName
        passengerStartTimes[id] = t
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
            val tripStartDest = Pair(passengerStartLocation[id]!!,stationName)
            val timeForTrip = t - passengerStartTimes[id]!!
            passengerStartLocation.remove(id)
            passengerStartTimes.remove(id)
            trips[tripStartDest] = trips.getOrDefault(tripStartDest,0)+1
            totalTimes[tripStartDest] = totalTimes.getOrDefault(tripStartDest,0)+timeForTrip
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val key = Pair(startStation,endStation)
        val trips = trips[key]!!.toDouble()
        val time = totalTimes[key]!!.toDouble()
        return time/trips
    }
}