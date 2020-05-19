/**
 * https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/submissions/
 */
class PeopleWhoseListOfFavoriteIsNotSubset {

    fun peopleIndexes(favoriteCompanies: List<List<String>>) : List<Int> {


        val companySets = favoriteCompanies.map { it.toSet() }
        val unique = BooleanArray(favoriteCompanies.size) {true}
        for (i in companySets.indices) {
            if (unique[i]) {
                val currSet = companySets[i]
                for(j in companySets.indices) {
                    val toCompare = companySets[j]
                    if (currSet.size > toCompare.size && currSet.containsAll(toCompare)) {
                        unique[j] = false
                    }
                }
            }
        }
        return unique
                .mapIndexed { index, b -> Pair(index,b) }
                .filter { it.second }
                .map { it.first }
                .sorted()




    }
}