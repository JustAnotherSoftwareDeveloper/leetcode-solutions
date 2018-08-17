class BuddyStrings {
    fun buddyStrings(A: String, B: String) : Boolean {
        //https://leetcode.com/problems/buddy-strings/description/
        if (A.length !== B.length) {
            return false
        }
        else if (A.length < 2) {
            return false
        }
        else if (A.length == 2 && A.equals(B)) {
            return A.toCharArray().toMutableSet().size == 1
        }
        else if (A.equals(B)) {
            return A.toCharArray().toMutableSet().size < A.length
        }
        val notMatchingIndex : MutableList<Int> = mutableListOf()
        for(i in 0 until A.length) {
            if (A[i] != B[i]) {
                notMatchingIndex.add(i)
                if (notMatchingIndex.size > 2) {
                    return false
                }
            }
        }
        if (notMatchingIndex.size == 1) {
            return false
        }
        else {
            return ((A[notMatchingIndex[0]] == B[notMatchingIndex[1]]) && (B[notMatchingIndex[0]] == A[notMatchingIndex[1]]))
        }
    }
}