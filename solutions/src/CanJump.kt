class CanJump {

    fun canJump(nums: IntArray) : Boolean{
        val dynamicJump = arrayOfNulls<Boolean>(nums.size)
        dynamicJump[0] = true
        for (i in 0 until dynamicJump.lastIndex) {
            if (dynamicJump[i] == true) {
                val maxJump = minOf(dynamicJump.lastIndex-i,nums[i])
                for (j in 0..maxJump) {
                    dynamicJump[i+j] = true
                }
            }
        }
        return dynamicJump[dynamicJump.lastIndex] != null
    }
}