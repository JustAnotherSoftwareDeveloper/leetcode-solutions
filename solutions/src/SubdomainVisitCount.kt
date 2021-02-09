/**
 * https://leetcode.com/problems/subdomain-visit-count/
 */
class SubdomainVisitCount {
    fun subdomainVisits(cpdomains: Array<String>): List<String> {
        return cpdomains.flatMap {
            val split = it.split(" ")
            val domainCounts = mutableListOf<Pair<Int,String>>();
            val count = Integer.parseInt(split[0]);
            var currDomain = split[1];

            while (currDomain.isNotEmpty()) {
                domainCounts.add(Pair(count,currDomain))
                var newIndex = currDomain.indexOfFirst { period -> period == '.' }

                currDomain = if (newIndex == -1) "" else currDomain.substring(newIndex+1);
            }

            domainCounts
        }
                .groupBy { it.second }
                .mapValues { it.value.map { count -> count.first }.sum() }
                .map { "${it.value} ${it.key}" }
    }
}