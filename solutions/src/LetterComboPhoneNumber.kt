//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class LetterComboPhoneNumber {
    fun letterCombinations(digits: String) : List<String> {


        val phoneMap = mapOf<Char,Set<String>>(
                Pair('2', setOf("a","b","c")),
                Pair('3', setOf("d","e","f")),
                Pair('4', setOf("g","h","i")),
                Pair('5', setOf("j","k","l")),
                Pair('6', setOf("m","n","o")),
                Pair('7', setOf("p","q","r","s")),
                Pair('8', setOf("t","u","v")),
                Pair('9', setOf("w","x","y","z"))
        )

        var combinations = mutableListOf("")
        for(digit: Char in digits) {
            val possibleLetters = phoneMap[digit] ?: error("Invalid Value")
            val newCombos = mutableListOf<String>()
            for (combo in combinations) {
                for (letter in possibleLetters) {
                    val newStr = combo+letter
                    newCombos.add(combo+letter)
                }
            }
            combinations = newCombos
        }
        return if (combinations.size == 1) listOf() else combinations
    }
}