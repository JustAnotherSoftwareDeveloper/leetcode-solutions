class RankTeamsByVotes {

    fun rankTeams(votes: Array<String>): String {
        val teams = votes[0].toList()
        val votesMaps = mutableListOf<MutableMap<Char,Int>>()
        for (i in teams.indices) {
            votesMaps.add(mutableMapOf())
        }
        votes.forEach { vote ->
            vote.forEachIndexed { index, c -> votesMaps[index][c] = votesMaps[index].getOrDefault(c,0)+1 }
        }

        val voteComparator : Comparator<Char> = Comparator{c1,c2 ->  compareVotes(c1,c2,votesMaps,teams)}
        val sortedTeams = teams.sortedWith(voteComparator)
        return sortedTeams.joinToString("")
    }

    private fun compareVotes(c1: Char, c2: Char, votesMaps: List<Map<Char,Int>>, teams: List<Char>) : Int {
        for (i in teams.indices) {
            val c1Votes = votesMaps[i].getOrDefault(c1,0)
            val c2Votes = votesMaps[i].getOrDefault(c2,0)
            if (c1Votes > c2Votes) {
                return -1
            }
            else if (c2Votes > c1Votes) {
                return 1
            }
        }
        return c1.compareTo(c2)
    }
}