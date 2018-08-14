class LengthOfLongestFibSequence {
    //https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/
    fun lenLongestFibSubseq(A: IntArray): Int {
        var longest = 0
        var index = 0
        // O(n)
        val valuesToIndex = A.mapIndexed { index, i -> Pair(i, index) }.associateBy({ it.first }, { it.second })
        val max = A.last()
        var sequences: Map<Int, List<List<Int>>> = mutableMapOf()
        val init: MutableList<List<Int>> = mutableListOf()
        //Prepopulate : O(n^2)
        for (i in 0 until A.size) {
            var j = i + 1
            while (j < A.size) {
                val fib = A[i]+A[j]
                init.add(listOf(A[i], A[j]))
                j++
            }
        }
        sequences += 2 to init
        longest = 2
        // O(log(n))
        while (sequences.getOrDefault(longest, listOf()).isNotEmpty()) {
            var nextLevel: MutableList<List<Int>> = mutableListOf()
            var currLongest = sequences[longest]!!
            currLongest.forEach { it -> //O(n^2)
                val previous = it[it.size-1]
                val beforeThat = it[it.size - 2]
                val fib = previous + beforeThat
                if (valuesToIndex.containsKey(fib) && valuesToIndex.getOrDefault(fib, Int.MAX_VALUE) > valuesToIndex.getOrDefault(previous,Int.MAX_VALUE)) {
                    nextLevel.add(it + fib)
                }
            }
            longest++
            sequences += longest to nextLevel
        }

        return when {
            longest - 1 < 3 -> 0
            else -> longest - 1
        }


    }
}