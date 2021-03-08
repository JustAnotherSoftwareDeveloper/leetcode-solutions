/**
 * https://leetcode.com/problems/replace-words/
 */
class ReplaceWords {

    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val root = Trie("",false)
        val sentenceList = sentence.split(" ");
        dictionary.forEach { build(it,"",root) }
        return sentenceList.map {
            traverse(it, root) ?: it
        }.joinToString(" ")
    }


    private fun traverse(word: String, node: Trie?) : String? {
        if (node == null) {
            return null
        }
        if (node.isLeaf) {
            return node.word
        }
        if (word == "") {
            return null
        }
        val top = word[0]
        val subStr = if (word.length == 1) "" else word.substring(1)
        return traverse(subStr,node.children[top])

    }

    private fun build(word: String, current: String, parent: Trie) {
        if (word == "") {
            parent.isLeaf = true;
            return
        }
        val top = word[0]
        val newCurrent = current+top
        val newLeaf : Trie = if (parent.children[top] == null) Trie(newCurrent,false) else parent.children[top]!!
        parent.children[top] = newLeaf
        val newWord = if (word.length == 1) "" else word.substring(1)
        build(newWord,newCurrent,newLeaf)
    }
    private class Trie(val word: String, var isLeaf: Boolean, val children: MutableMap<Char,Trie> = mutableMapOf())
}