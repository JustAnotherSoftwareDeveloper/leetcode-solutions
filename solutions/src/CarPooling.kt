/**
 * https://leetcode.com/problems/car-pooling/submissions/
 */
class CarPooling {

    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {

        val maxDistance = trips.flatMap { it.toList() }.max()!!

        val pickUps = mutableMapOf<Int,Int>()
        val dropOffs = mutableMapOf<Int,Int>()

        for (trip in trips) {
            pickUps[trip[1]] = pickUps.getOrDefault(trip[1],0)+trip[0]
            dropOffs[trip[2]] = dropOffs.getOrDefault(trip[2],0)+trip[0]
        }

        var currentPool = 0
        for (i in 0..maxDistance) {
            var toPickUp = pickUps.getOrDefault(i,0)
            var toDropOff = dropOffs.getOrDefault(i,0)

            currentPool = currentPool+toPickUp-toDropOff

            if (currentPool > capacity) {
                return false
            }
        }

        return true


    }
}