class RedundantConnection {

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {

       var connectedSets = mutableSetOf<MutableSet<Int>>()

        val validEdges = mutableListOf<IntArray>()
        for (edge in edges) {

            val matchingSets = mutableListOf<MutableSet<Int>>()
            val notMatchingSets = mutableListOf<MutableSet<Int>>()
            for (s in connectedSets) {
                if (s.contains(edge[0]) || s.contains(edge[1])) {
                    matchingSets.add(s)
                }
                else {
                    notMatchingSets.add(s)
                }
            }
            if (matchingSets.isEmpty()) {
                connectedSets.add(mutableSetOf(edge[0],edge[1]))
            }
            else if (matchingSets.size == 2) {
                val newSet = matchingSets.reduce { acc, mutableSet -> (acc+mutableSet).toMutableSet() }
                connectedSets = (notMatchingSets+listOf(newSet)).toMutableSet()
            }
            else if (matchingSets[0].contains(edge[0]) && matchingSets[0].contains(edge[1])) {
                validEdges.add(edge)
            }
            else {
                matchingSets[0].addAll(edge.toList())
            }
        }
        return validEdges.last()
    }


}