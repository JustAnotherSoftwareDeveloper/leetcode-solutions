class Abbreviation {

    fun abbreviation(a: String, b: String): String {
        if (b.length > a.length) {
            return "NO";
        }

        val dpAbbr = Array(a.length+1){BooleanArray(b.length+1)};
        dpAbbr[0][0] = true;
        var upperEncoutered = false;
        for (i in a.indices) {
            if (a[i].isUpperCase()) {
                upperEncoutered = true;
                dpAbbr[i+1][0] = false;
            }
            dpAbbr[i+1][0] = !upperEncoutered
        }
        for (i in 1..a.length) {
            var m = i-1
            for (j in 1..b.length) {
                var n = j-1
                when {
                    a[m]==b[n] -> {
                        dpAbbr[i][j] = dpAbbr[i-1][j-1]
                    }
                    a[m].toUpperCase() == b[n] -> {
                        dpAbbr[i][j] = dpAbbr[i-1][j-1] || dpAbbr[i-1][j]
                    }
                    a[m].isUpperCase() -> {
                        dpAbbr[i][j] = false
                    }
                    else -> {
                        dpAbbr[i][j] = dpAbbr[i-1][j]
                    }
                }
            }
        }
        return if(dpAbbr[a.length][b.length]) "YES" else "NO"
    }
}