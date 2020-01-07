class IntegerToRoman {

    fun intToRoman(num: Int) : String {
        var modified = num
        var roman = ""
        val romanMap = mapOf(Pair(1000, "M"), Pair(900, "CM"), Pair(500, "D"), Pair(400, "CD"), Pair(100, "C"), Pair(90, "XC"), Pair(50, "L"), Pair(40, "XL"), Pair(10, "X"), Pair(9, "IX"), Pair(5, "V"), Pair(4, "IV"), Pair(1, "I"))
        romanMap.entries.forEach{
            while (modified / it.key != 0) {
                roman += it.value
                modified-=it.key
            }
        }
        return roman
    }

}