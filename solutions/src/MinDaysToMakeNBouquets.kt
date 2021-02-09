class MinDaysToMakeNBouquets {

    fun minDays(bloomDay: IntArray, m: Int, k : Int) : Int {
        if (bloomDay.size < m*k) {
            return -1;
        }

        var maxDay = bloomDay.max()!!
        var minDay = 1;
        var goodDay = -1;
        while (maxDay >= minDay) {
            val mid = minDay + (maxDay-minDay)/2;
            var contiguousSections = mutableListOf<Int>()
            var currentSection = 0;
            for (i in bloomDay.indices) {
                if (bloomDay[i] <= mid) {
                    currentSection++
                }
                else {
                    contiguousSections.add(currentSection);
                    currentSection =0
                }
            }
            contiguousSections.add(currentSection);
            val bouquets = contiguousSections.map { it/k }.sum()
            if (bouquets >= m) {
                maxDay = mid-1;
                goodDay = mid;
            }
            else {
                minDay = mid+1;
            }
        }



        return goodDay
    }
}