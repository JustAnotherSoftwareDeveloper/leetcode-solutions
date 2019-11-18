import java.math.BigInteger
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.LinkedHashMap

class LRUCache(capacity: Int): LinkedHashMap<Int,Int>(capacity,0.75F,true)  {


    private val totalCapacity = capacity

    override fun get(key: Int) : Int {
        return super.getOrDefault(key,-1)
    }

    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
        return size > totalCapacity
    }

}