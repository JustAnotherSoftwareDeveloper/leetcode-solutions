import java.util.*
import kotlin.Comparator

class TimeMap {

    private class SortByTimestampComparator : Comparator<Pair<Int,String>> {
        override fun compare(p0: Pair<Int, String>?, p1: Pair<Int, String>?): Int {
           if (p0 == null && p1 == null) {
               return 0
           }
            if (p0 == null) {
                return 1
            }
            if (p1 == null) {
                return -1
            }
            return p0.first.compareTo(p1.first)
        }

    }
    private val store = TreeMap<String,TreeSet<Pair<Int,String>>>()
    fun set(key: String, value: String, timestamp: Int) {
        store.computeIfAbsent(key) {TreeSet(SortByTimestampComparator()) }.add(Pair(timestamp,value))
    }

    fun get(key: String, timestamp: Int) : String {
            val returnPair = store.getOrDefault(key,TreeSet()).floor(Pair(timestamp,""))
            return (returnPair ?: Pair(timestamp,"")).second
    }
}