/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
class MinNumberOfArrowsToBurstBalloon {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        var balloons = points.map { Pair(it[0],it[1]) }.sortedBy { it.second }
        if (balloons.isEmpty()) {
            return 0
        }
        var position = balloons[0].second
        var arrows = 1
        for (i in 1 until balloons.size) {
            if (position >= balloons[i].first) {
                continue
            }
            arrows++
            position = balloons[i].second
        }
        return arrows
    }


}