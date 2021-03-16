/**
 * https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
 */
class FilterResturantsByFactors {

    fun filterRestaurants(restaurants: Array<IntArray>, veganFriendly: Int, maxPrice: Int, maxDistance: Int): List<Int> {

        return restaurants.filter {
            val validPrice = it[3] <= maxPrice
            val validDistance = it[4] <= maxDistance
            val validVegan = veganFriendly == 0 || it[2] == 1
            validDistance && validPrice && validVegan
        }
                .sortedWith(compareByDescending<IntArray> { it[1] }.thenByDescending{it[0]})
                .map { it[0] }
    }
}