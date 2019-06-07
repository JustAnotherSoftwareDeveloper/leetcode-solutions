//https://leetcode.com/problems/find-the-town-judge/
class TownJudge {
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        val from = mutableSetOf<Int>()
        val trustedBy = mutableMapOf<Int,Int>()
        for (i in 1..N) {
            trustedBy[i] = 0
        }
        trust.forEach {
            val trusting = it[0]
            val trusted = it[1]
            from.add(trusting)
            trustedBy[trusted] = trustedBy[trusted]!!+1
        }
        val possibleJudges = trustedBy.filter { it.value == N-1 }.map { it.key }.filter { !from.contains(it) }

        return if (possibleJudges.size == 1) possibleJudges[0] else -1
    }
}