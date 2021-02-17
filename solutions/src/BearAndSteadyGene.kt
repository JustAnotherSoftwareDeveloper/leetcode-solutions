/**
 * https://www.hackerrank.com/challenges/bear-and-steady-gene/problem
 */
class BearAndSteadyGene {

    // Complete the steadyGene function below.
    fun steadyGene(gene: String): Int {

        val desired = gene.length/4
        val geneCount = gene.toList().groupingBy { it }.eachCount().toMutableMap()

        var minLength = gene.length
        var i = 0
        var j = 0
        while (i < gene.length && j < gene.length) {
            if (!balanced(geneCount,desired)) {
                geneCount[gene[j]] = geneCount.getOrDefault(gene[j],0)-1
                j++
            }
            else {
                minLength = minOf(minLength, j-i)
                geneCount[gene[i]] = geneCount.getOrDefault(gene[i],0)+1
                i++
            }
        }


        return minLength


    }

    private fun balanced(map: Map<Char,Int>,n: Int) : Boolean {
        return map.all { it.value <= n }
    }
}