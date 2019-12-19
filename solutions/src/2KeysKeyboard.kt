class `2KeysKeyboard` {
    fun minSteps(n: Int) : Int {
        var min = 0
        var denominator = 2
        var strSize = n
        while (strSize > 1) {
            while (strSize % denominator == 0) {
                min+=denominator
                strSize/=denominator
            }
            denominator++
        }
        return min
    }



}