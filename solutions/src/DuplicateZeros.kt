import java.util.*
import kotlin.collections.ArrayList

class DuplicateZeros {
    fun duplicateZeros(arr: IntArray) : Unit {
        val zerosAt = mutableListOf<Int>()
        arr.forEachIndexed{index, i -> if(i == 0) {zerosAt.add(index)} }
        var insertedZeros = 0
        val arrClone = arr.toMutableList()
        zerosAt.forEach{
            val trueInsert = it+insertedZeros
            arrClone.add(trueInsert,0)
            insertedZeros++
        }

    }
}