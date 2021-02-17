/**
 * https://www.hackerrank.com/challenges/torque-and-development/problem
 *
 * Getting timeouts on 2 cases, but I think that's due to problems with java speed.
 * Looking at the comments, I'm completing the correct O(n) solution
 */
class TorqueAndDevelopment {

    // Complete the roadsAndLibraries function below.
    fun roadsAndLibraries(n: Int, c_lib: Int, c_road: Int, cities: Array<Array<Int>>): Long {
        val citySet = mutableSetOf<Int>()
        cities.forEach {
            citySet.add(it[0])
            citySet.add(it[1])
        }
        if (c_road > c_lib) {

            return c_lib.toLong()*n
        }
        val possibleRoads = mutableMapOf<Int,MutableList<Int>>()
        cities.forEach {
            possibleRoads.computeIfAbsent(it[0]){ mutableListOf()}.add(it[1])
            possibleRoads.computeIfAbsent(it[1]){ mutableListOf()}.add(it[0])
        }
        val visited = mutableSetOf<Int>()
        var total = 0L

        for (city in 1..n) {
            total+=dfs(city,possibleRoads,visited,c_lib,c_road,true)
        }

        return total

    }

    private fun dfs(city: Int, possibleRoads: Map<Int,List<Int>>, visited: MutableSet<Int>, libraryCost: Int, roadCost: Int, start: Boolean) : Long {
        if (visited.contains(city)) {
            return 0
        }
        visited.add(city)
        var initialCost = (if (start) libraryCost else roadCost).toLong()
        initialCost
        for (c in possibleRoads.getOrDefault(city, listOf())) {
            initialCost+=dfs(c,possibleRoads,visited,libraryCost,roadCost,false)
        }
        return initialCost
    }
}