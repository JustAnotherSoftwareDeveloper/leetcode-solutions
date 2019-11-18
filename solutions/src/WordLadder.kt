import java.lang.StringBuilder

class WordLadder {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>) : Int {
        val comboDictionary = mutableMapOf<String,List<String>>()
        wordList.forEach {
            for (i in it.indices) {
                var transformed = StringBuilder(it)
                transformed[i] = '*'
                comboDictionary[transformed.toString()] = (comboDictionary[transformed.toString()] ?: listOf())+it
            }
        }

        val queue = mutableListOf<Pair<String,Int>>()
        var currentPair = Pair(beginWord,1)
        val visited = mutableSetOf<String>()
        queue.add(currentPair)
        while(queue.isNotEmpty()) {
            currentPair=queue.removeAt(0)
            val currentString = currentPair.first
            visited.add(currentString)
            val toAdd = mutableSetOf<String>()
            if (currentString == endWord) {
                return currentPair.second
            }
            for (i in currentString.indices) {
                var transformed = StringBuilder(currentString)
                transformed[i] = '*'
                toAdd.addAll(comboDictionary[transformed.toString()] ?: listOf())
            }
            queue.addAll(toAdd.filter { !visited.contains(it) }.map { Pair(it,currentPair.second+1) })
        }
        return 0
    }
}