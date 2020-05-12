class CanStringBreak {

    fun  checkIfCanBreak(s1: String, s2: String) : Boolean {
        var canBreakS1 = true
        var canBreakS2 = true
        val s1List = convertToNumericalRep(s1)
        val s2List = convertToNumericalRep(s2)
        for (i in s1List.indices) {
            val s1Char = s1List[i]
            val s2Char = s2List[i]
            canBreakS1 = canBreakS1 && s2Char >= s1Char
            canBreakS2 = canBreakS2 && s1Char >= s2Char
        }
        return canBreakS1 || canBreakS2
    }



    private fun convertToNumericalRep(s: String) : List<Int> {
        val charList = charArrayOf('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z')
        val charMap = charList.mapIndexed{ index, c-> Pair(c,index)}.toMap()
        return s.map { charMap[it]!! }.sorted()
    }
}