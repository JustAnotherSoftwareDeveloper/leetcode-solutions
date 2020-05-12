class KthLexigraphicalStringOfAllHappyStringsLengthN {
    fun getHappyString(n: Int, k: Int): String {
        val characters = charArrayOf('a', 'b', 'c')
        val validStrings = mutableListOf<String>()
        val queue = mutableListOf("")
        while (queue.isNotEmpty()) {
            val currString = queue.removeAt(0)
            if (currString.length == n ) {
                validStrings.add(currString)
            } else {
                queue.addAll(characters.map { currString + it }.filter { it.length < 2 || it[it.lastIndex] != it[it.lastIndex - 1] })
            }
        }

        return if (k > validStrings.size) "" else validStrings.sorted()[k-1]
    }
}