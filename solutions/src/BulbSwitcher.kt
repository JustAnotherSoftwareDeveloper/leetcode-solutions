import kotlin.math.sqrt

/**
 * https://leetcode.com/problems/bulb-switcher/
 */
class BulbSwitcher {
    fun bulbSwitch(n: Int) : Int {
        return sqrt(n.toDouble()).toInt()
    }
}