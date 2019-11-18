class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>) : List<List<String>> {
        val anagramsBySortedString = mutableMapOf<String,List<String>>()
        strs.forEach {
            val sorted = it.toCharArray().sorted().toString()
            anagramsBySortedString[sorted] = (anagramsBySortedString[sorted] ?: mutableListOf())+it
        }
        return anagramsBySortedString.values.toList()
    }
}