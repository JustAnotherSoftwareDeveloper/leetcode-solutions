import kotlin.math.max
import kotlin.math.min

data class Room(val currentVal: Int, val lowestVal: Int) {

}
class DungeonGame {
//https://leetcode.com/problems/dungeon-game/submissions/1
    fun calculateMinimumHP(dungeon : Array<IntArray>) : Int {
        val rows = dungeon.size
        val cols = dungeon.first().size
        val dynamicValues: Array<Array<Room?>> = Array(rows) { arrayOfNulls<Room>(cols) }
        var i =rows -1
        var j = cols -1
        while (i >= 0) {

            while (j >= 0) {
                if (i+1 == rows && j+1 == cols) {
                    if (dungeon[i][j] > 0) {
                        dynamicValues[i][j]=Room(dungeon[i][j],0)
                    }
                    else {
                        dynamicValues[i][j]=Room(dungeon[i][j],dungeon[i][j])
                    }

                }
                else if (i+1 == rows) {
                    val prevRoom = dynamicValues[i][j+1]!!
                    dynamicValues[i][j]=createRoom(prevRoom,dungeon[i][j])
                }
                else if (j+1 == cols) {
                    val prevRoom = dynamicValues[i+1][j]!!
                    dynamicValues[i][j]=createRoom(prevRoom,dungeon[i][j])
                }
                else {
                    val oneRight = dynamicValues[i+1][j]!!
                    val newLowRight = calcNewLow(oneRight,dungeon[i][j])
                    val oneDown = dynamicValues[i][j+1]!!
                    val newDownLow = calcNewLow(oneDown,dungeon[i][j])
                    if (newLowRight > newDownLow) {
                        dynamicValues[i][j]=createRoom(oneRight,dungeon[i][j])
                    }
                    else if (newDownLow > newLowRight) {
                        dynamicValues[i][j]=createRoom(oneDown,dungeon[i][j])
                    }
                    else {
                        if (oneRight.currentVal > oneDown.currentVal) {
                            dynamicValues[i][j]=createRoom(oneRight,dungeon[i][j])

                        }
                        else {
                            dynamicValues[i][j]=createRoom(oneDown,dungeon[i][j])
                        }
                    }

                }

                j--
            }
            j = cols -1
            i--
        }

        val lowestVal = dynamicValues[0][0]!!.lowestVal
        println(dynamicValues[0][0])
        if (lowestVal > 0) {
            return 1
        }
        return 1-lowestVal
    }

    fun calcNewLow(r: Room, value: Int) : Int{
        return min(r.lowestVal,(r.currentVal+value))
    }


    fun createRoom(old: Room, value: Int) : Room {
        val currentVal = value+old.currentVal
        println(value)
        println(old)
        if (value >= 0) {
            if (currentVal >=0) {
                println("Case 1")
                return Room(currentVal, 0)
            }
            else {
                println("Case 2")
                return Room(currentVal,currentVal)
            }
        }
        else {
            if (old.currentVal < 0) {
                println("Case 3")
                return Room(currentVal,min(currentVal,old.lowestVal))
            }
            else {
                println("Case 4")
                return Room(value,min(value,old.lowestVal))
            }

        }
    }

}