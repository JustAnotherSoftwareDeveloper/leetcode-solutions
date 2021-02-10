import java.util.*
import kotlin.Comparator

/**
 * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 */
class OrganizingContainersOfBalls {
    // Complete the organizingContainers function below.
    fun organizingContainers(container: Array<Array<Int>>): String {
        val ballAmount = TreeMap<Int,Long>()
        val containerAmount = TreeMap<Long,MutableList<Int>>()

        for (i in container.indices) {
            val sum = container[i].sumByDouble { it.toDouble()}.toLong()
            containerAmount.computeIfAbsent(sum) { mutableListOf() }.add(i)
            for (j in container[0].indices) {
                ballAmount[j] = ballAmount.getOrDefault(j,0)+container[i][j]
            }
        }

        val sortedBallAmount = ballAmount.toSortedMap()

        for (entry in sortedBallAmount.entries.reversed()) {
            val amount = entry.value
            val highestEntry = containerAmount.tailMap(amount,true).firstEntry() ?: return "Impossible"
            val list = highestEntry.value
            if (list.isEmpty()) {
                return "Impossible"
            }
            list.removeAt(0)
            if (list.isEmpty()) {
                containerAmount.remove(highestEntry.key)
            }

        }
        return "Possible";

    }

}