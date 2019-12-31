import java.util.*

class CheapestFlights {

    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dest: Int, K: Int) : Int {
        val flightConnections : MutableMap<Int,MutableSet<FlightPath>> = mutableMapOf()
        flights.forEach {
            flightConnections.computeIfAbsent(it[0]) { mutableSetOf()}.add(FlightPath(airport = it[1],cost = it[2]))
        }
        val visited = mutableSetOf<Int>()
        val endingPaths = mutableListOf<FlightPath>()
        val queueComparator : Comparator<FlightPath> = Comparator { a: FlightPath, b : FlightPath -> a.cost.compareTo(b.cost)}
        val queue = PriorityQueue<FlightPath>(queueComparator)
        queue.add(FlightPath(0,src,0))
        while (queue.isNotEmpty()) {
            val flightPath = queue.poll()
            if (flightPath.airport == dest)  {
               return flightPath.cost
            }
            else {
                queue.addAll(flightConnections.getOrDefault(flightPath.airport, mutableSetOf()).filter {flightPath.steps <= K }.map { FlightPath(flightPath.cost+it.cost,it.airport,flightPath.steps+1) })
            }
        }
        return -1
    }

    private data class FlightPath(val cost: Int, var airport: Int, val steps: Int = 0)
}