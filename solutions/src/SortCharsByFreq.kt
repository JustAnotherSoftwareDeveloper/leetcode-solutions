class SortCharsByFreq {
    //https://leetcode.com/problems/sort-characters-by-frequency/description/

    fun frequencySort(s: String) : String {
        return s.toList().groupingBy { it }.eachCount().entries.sortedByDescending { it.value }.map { it.key.toString().repeat(it.value) }.joinToString(separator = "")
    }
} 