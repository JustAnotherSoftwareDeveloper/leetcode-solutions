class AlmostSorted {

    fun almostSorted(arr: Array<Int>) {
        var sorted = false;

        //Swap
        var swapIndicies = mutableSetOf<Int>()

        for (i in arr.indices) {
            if (i < arr.lastIndex && arr[i] > arr[i+1]) {
                swapIndicies.add(i)
            }
            if (i > 0 && arr[i] < arr[i-1]) {
                swapIndicies.add(i)
            }
        }
        var list = arr.toMutableList()
        var swapList = swapIndicies.toList()
        var swapOne = 0
        var swapTwo = 0
        when (swapIndicies.size) {
            2 -> {
                //Possible Match
                swapTwo = 1
            }
            3 -> {
                swapTwo = 2
            }
            4 -> {
                swapTwo = 3
            }
        }
        list[swapList[swapOne]] = arr[swapList[swapTwo]]
        list[swapList[swapTwo]] = arr[swapList[swapOne]]
        sorted = checkSorted(list)
        if (sorted) {
            println("yes")
            println("swap ${swapList[swapOne]+1} ${swapList[swapTwo]+1}")
            return
        }
        //Reverse
        var sortedAt = BooleanArray(arr.size)

        sortedAt[0] = true
        for (i in sortedAt.indices) {
            var sortedAtIndex = true;
            if (i > 0 && arr[i] < arr[i-1] ) {
                sortedAtIndex = false
            }
            if (i < sortedAt.lastIndex && arr[i] > arr[i+1]) {
                sortedAtIndex = false
            }
            sortedAt[i] = sortedAtIndex
        }

        var startIndex = -1
        var endIndex = -1
        var found = false
        for (i in sortedAt.indices) {
            if (!sortedAt[i] && startIndex == -1) {
                startIndex = i
            }
            if (!sortedAt[i] && !found) {
                endIndex = i
            }
            if (!sortedAt[i] && found) {
                println("no")
                return
            }
            if (sortedAt[i] && startIndex != -1 && endIndex != -1) {
                found = true
            }
        }

        var newList = if (startIndex > 0) {
            arr.toList().subList(0,startIndex)
        }
        else {
            listOf()
        }
        newList = newList+arr.toList().subList(startIndex,endIndex+1).reversed()
        if (endIndex < arr.lastIndex) {
            newList = newList+arr.toList().subList(endIndex+1,arr.size)
        }
        sorted = checkSorted(newList)
        if (sorted) {
            println("yes")
            println("reverse ${startIndex+1} ${endIndex+1}")
            return
        }
        println("no")




    }

    private fun checkSorted(list: List<Int>) : Boolean {
        var sorted = true
        var current = list[0]
        for (i in 1 until list.size) {
            if (list[i-1] >= list[i]) {
                sorted = false;
            }
        }
        return sorted
    }
}