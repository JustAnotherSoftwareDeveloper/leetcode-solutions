class AccountMerge {

    fun accountsMerge(accounts: List<List<String>>) : List<List<String>> {
        val accountsAsObjects = accounts.map { fromList(it) }
        val emailsToAccounts = mutableMapOf<String,MutableList<Account>>()
        accountsAsObjects.forEach {
            it.emails.forEach {email -> emailsToAccounts.computeIfAbsent(email) { mutableListOf()}.add(it) }
        }
        val visited = mutableSetOf<String>()
        val merged = mutableListOf<Account>()
        while (visited.size != emailsToAccounts.size) {
            val seedAccount = emailsToAccounts[emailsToAccounts.keys.first { !visited.contains(it) }]
            val name = seedAccount!![0].name
            val emails = seedAccount!![0].emails.toMutableSet()
            val queue = emails.toMutableList()
            visited.addAll(emails)
            while (queue.isNotEmpty()) {
                val email = queue.removeAt(0);
                emailsToAccounts[email]!!.flatMap { it.emails }.forEach { addr ->
                    if (!visited.contains(addr)) {
                        visited.add(addr)
                        emails.add(addr)
                        queue.add(addr)
                    }
                }
            }
            merged.add(Account(name,emails))
        }
        return merged.map { it.toList() }
    }

    private fun fromList(l:List<String>) : Account {
        return Account(l[0],(1 until l.size).map { l[it] }.toSet());
    }
    private data class Account(val name: String, val emails: Set<String>) {

        fun toList() : List<String> {
            val toList = mutableListOf(this.name)
            toList.addAll(emails.sorted())
            return toList.toList()
        }
    }
}