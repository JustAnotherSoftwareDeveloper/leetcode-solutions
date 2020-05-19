

/**
 * https://leetcode.com/problems/rearrange-words-in-a-sentence/
 */
class RearrangeWordsInSequence {

    fun arrangeWords(text: String) : String {
        return text
                .split(Regex("\\s"))
                .mapIndexed { index, s -> WordSorter(s, index, s.length) }
                .sortedWith(compareBy({ it.len }, { it.index }))
                .mapIndexed { index, wordSorter ->
                    if (index == 0) {
                        wordSorter.word.capitalize()
                    }
                    else {
                        wordSorter.word.toLowerCase()
                    }
                }
                .joinToString(separator = " ")

    }


    private class WordSorter(val word: String, val index: Int, val len: Int)
}