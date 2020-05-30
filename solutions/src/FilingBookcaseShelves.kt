/**
 * https://leetcode.com/problems/filling-bookcase-shelves/
 */
class FilingBookcaseShelves {
    fun minHeightShelves(books: Array<IntArray>, shelf_width: Int): Int {
        val dp = IntArray(books.size + 1)

        dp[0] = 0

        for (i in 1..books.size) {
            var width = books[i - 1][0]
            var height = books[i - 1][1]
            dp[i] = dp[i - 1] + height
            var j = i - 1
            while (j > 0 && width + books[j - 1][0] <= shelf_width) {
                height = maxOf(height, books[j - 1][1])
                width += books[j - 1][0]
                dp[i] = minOf(dp[i], dp[j - 1] + height)
                --j
            }
        }
        return dp[books.size]
    }
}