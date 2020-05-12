class CheckIfAllOnesAreKPlacesAway {
    fun kLengthApart(nums: IntArray, k: Int) : Boolean {
        var currLength = Int.MAX_VALUE
        for (i in nums.indices) {
            if (nums[i] == 1) {
                if (currLength < k) {
                    return false
                }
                else {
                    currLength = 0
                }
            }
            else {
                if (currLength < Int.MAX_VALUE) {
                    currLength++
                }
            }
        }
        return true
    }
}