class DayOfWeek {
    fun dayOfTheWeek(day: Int, month: Int, year: Int) : String {
        val weekDays = listOf("Friday","Saturday","Sunday","Monday","Tuesday","WednesDay","Thursday");

        var totalDays = day;
        for (i in 1971 until year) {
            totalDays+=determineDaysInYear(i)
        }
        for( i in 1 until month) {
            totalDays+=determineDaysInMonth(i,year)
        }
        return weekDays[(totalDays-1) % 7]

    }

    private fun determineDaysInYear(year: Int) :Int {
        return if (isLeapYear(year)) 366 else 365
    }

    private fun determineDaysInMonth(month : Int, year: Int) : Int {
        val thirtyDays = setOf(9,4,6,11)
        val thirtyOneDays = setOf(1,3,5,7,8,10,12)
        return when {
            thirtyDays.contains(month) -> 30
            thirtyOneDays.contains(month) -> 31
            isLeapYear(year) -> 29
            else -> 28
        }
    }

    private fun isLeapYear(year: Int) : Boolean {
        return year % 4 == 0 && (!(year % 100 == 0) || (year % 400 == 0))
    }
}