import java.util.*

/**
 * https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/
 */
class DisplayFoodOrders {

    fun displayTable(orders: List<List<String>>) : List<List<String>> {
        val returnList = mutableListOf<List<String>>()
        val allFoods = orders.map { it[2] }.distinct().sorted()
        val people = mutableMapOf<Int,MutableMap<String,Int>>()
        orders.forEach {
            var derivedTable = Integer.parseInt(it[1])
            val foods = people.computeIfAbsent(derivedTable) { mutableMapOf()}
            foods[it[2]] = foods.computeIfAbsent(it[2]) {0} + 1
        }
        val headerList = mutableListOf("Table")
        headerList.addAll(allFoods)
        returnList.add(headerList)
        people.keys.sorted().forEach {
            val descriptionList = mutableListOf<String>()
            descriptionList.add(it.toString())
            val foods = people[it]!!
            allFoods.forEach { food ->
                descriptionList.add(foods.getOrDefault(food,0).toString())
            }
            returnList.add(descriptionList)
        }






        return returnList
    }

}