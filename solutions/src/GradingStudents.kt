/**
 * https://www.hackerrank.com/challenges/grading/problem
 */
class GradingStudents {

    fun gradingStudents(grades: Array<Int>) : Array<Int> {
        return grades.map { roundGrades(it) }.toTypedArray()
    }

    private fun roundGrades(grade: Int) : Int {
        val mod = 5 - grade % 5
        return  if (mod < 3) {
            when {
                grade < 38 -> grade
                grade <= 40 -> 40
                grade <= 45 -> 45
                grade <= 50 -> 50
                grade <= 55 -> 55
                grade <= 60 -> 60
                grade <= 65 -> 65
                grade <= 70 -> 70
                grade <= 75 -> 75
                grade <= 80 -> 80
                grade <= 85 -> 85
                grade <= 90 -> 90
                grade <= 95 -> 95
                else -> 100
            }
        }
        else {
            grade
        }

    }
}