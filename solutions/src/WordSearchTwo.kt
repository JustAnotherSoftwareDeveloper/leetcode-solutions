
//https://leetcode.com/problems/word-search-ii/
class WordSearchTwo {

    private val grid: MutableMap<Pair<Int, Int>, Char> = mutableMapOf()
    private val foundWords = mutableSetOf<String>()
    private class CharTree(val value: Char, val children: MutableMap<Char,CharTree?> = mutableMapOf() )
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        grid.clear()
        foundWords.clear()
        for (i in 0 until board.size) { // m*n
            for (j in 0 until board[i].size) {
                grid[Pair(i, j)] = board[i][j]
            }
        }
        val rootTree = CharTree('#')
        words.forEach { buildTree(it,rootTree) }
        grid.keys.forEach { traverseTree(it, mutableSetOf(), StringBuilder(), rootTree) }

        return words.filter { foundWords.contains(it) }
    }
    private fun buildTree(word: String, tree: CharTree) {
        val wordList = word.toMutableList()
        var current = tree
        while (wordList.isNotEmpty()) {
            val currentChar = wordList.removeAt(0)
            var child = current.children[currentChar]
            if (child== null) {
                child = CharTree(currentChar)
                current.children[currentChar] = child
            }
            current = child
        }
    }
    private fun traverseTree(location: Pair<Int,Int>, found: MutableSet<Pair<Int,Int>>, sb: StringBuilder, tree: CharTree?) {
        if (tree == null) {
            return
        }
        if (tree.value == '#') {
            traverseTree(location,found,sb, tree.children[grid.getValue(location)])
            return
        }
        found.add(location)
        sb.append(tree.value)
        foundWords.add(sb.toString())
        listOf(
                Pair(location.first + 1, location.second),
                Pair(location.first - 1, location.second),
                Pair(location.first, location.second + 1),
                Pair(location.first, location.second - 1)
        )
                .filter { grid.containsKey(it) && !found.contains(it)}
                .forEach{
                    traverseTree(it, found.toMutableSet(), StringBuilder(sb), tree.children[grid.getValue(it)])
                }
    }
}