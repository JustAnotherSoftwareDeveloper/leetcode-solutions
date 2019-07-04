class NonOverlappingIntervals {

    fun eraseOverlapIntervals(intervals: Array<IntArray>) : Int {

        if (intervals.size < 2) {
            return 0
        }
        var toErase = 0
        val descendingComparator = compareByDescending<IntArray> { it[0] }.thenByDescending { it[1] }

        val sortedIntervals = intervals.sortedWith(descendingComparator)
        var previous = sortedIntervals[0]
        sortedIntervals.forEach{interval ->
            if (interval[1] > previous[0]) {
                toErase++
            }
            else {
                previous = interval
            }
        }




        println(toErase-1)
        return toErase-1
    }
}