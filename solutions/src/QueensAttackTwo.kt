/**
 * https://www.hackerrank.com/challenges/queens-attack-2/problem
 */
class QueensAttackTwo {

    fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<Array<Int>>): Int {

        val obstaclesSet = obstacles.map { Pair(it[0]-1,it[1]-1) }.toSet()

        var i = r_q-1;
        var j = c_q-1
        var moves = 0
        //Up
        while (inBounds(i+1,j,n)) {
            i++
            if (obstaclesSet.contains(Pair(i,j))) {
                break;
            }
            else {
                moves++
            }
        }
        i = r_q-1
        j = c_q-1
        while (inBounds(i-1,j,n)) {
            i--
            if (obstaclesSet.contains(Pair(i,j))) {
                break;
            }
            else {
                moves++
            }
        }
        i = r_q-1
        j = c_q-1
        //Right
        while (inBounds(i,j+1,n)) {
            j++
            if (obstaclesSet.contains(Pair(i,j))) {
                break;
            }
            else {
                moves++
            }
        }
        i = r_q-1
        j = c_q-1
        //Left
        while (inBounds(i,j-1,n)) {
            j--
            if (obstaclesSet.contains(Pair(i,j))) {
                break
            }
            else {
                moves++
            }
        }
        i = r_q-1
        j = c_q-1
        //Diag Up-Left
        while (inBounds(i-1,j+1,n)) {
            i--
            j++
            if (obstaclesSet.contains(Pair(i,j))) {
                break
            }
            else {
                moves++
            }
        }
        i = r_q-1
        j = c_q-1
        //Diag Down Left
        while (inBounds(i-1,j-1,n)) {
            i--
            j--
            if (obstaclesSet.contains(Pair(i,j))) {
                break
            }
            else {
                moves++
            }
        }
        i = r_q-1
        j = c_q-1
        //Diag Up Right
        while (inBounds(i+1,j+1,n)) {
            i++
            j++
            if (obstaclesSet.contains(Pair(i,j))) {
                break
            }
            else {
                moves++
            }
        }
        i = r_q-1
        j = c_q-1
        //Diag Down Right
        while (inBounds(i+1,j-1,n)) {
            i++
            j--
            if (obstaclesSet.contains(Pair(i,j))) {
                break
            }
            else {
                moves++
            }
        }
        return moves
    }




    private fun inBounds(i: Int, j: Int, size: Int): Boolean {
        return i in 0 until size && j in 0 until size
    }
}