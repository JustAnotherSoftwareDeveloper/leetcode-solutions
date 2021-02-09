import kotlin.math.ceil
import kotlin.math.pow

/**
 * https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/submissions/
 */
class FindPathInZigZagTree {
    fun pathInZigZagTree(label: Int) : List<Int> {
        var labelMutable = label;
        val path = mutableListOf<Int>()

        var numNodes = 1
        var level = 1
        while (label >= numNodes*2) {
            numNodes*=2
            level++
        }
        while (level >= 1 ) {
            path.add(0,labelMutable)
            val maxLevel = Math.pow(2.0,level.toDouble()).toInt()-1
            val minLevel = Math.pow(2.0,level.toDouble()-1).toInt();
            labelMutable = (maxLevel+minLevel-labelMutable) /2;
            level--
        }

        return path;




    }
}