/**
 * https://leetcode.com/problems/restore-ip-addresses/
 */
class RestoreIpAddresses {
    fun restoreIpAddresses(s: String) : List<String> {
        val validAddresses = mutableListOf<List<String>>()
        val queue = mutableListOf(QueueItem(remainingChars = s.toCharArray()))
        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0);
            if (current.addressList.size == 4) {
                if (current.remainingChars.isEmpty()) {
                    validAddresses.add(current.addressList)
                }
            }
            else {
                listOfNotNull(
                        createNewQueueItem(current, 1),
                        createNewQueueItem(current, 2),
                        createNewQueueItem(current, 3)
                ).forEach{queue.add(it)}
            }
        }
        return validAddresses.map { it.joinToString(separator = ".") }
    }


    private fun createNewQueueItem(current: QueueItem, size: Int) : QueueItem? {
        val remainingChars = current.remainingChars
        val addressList = current.addressList.toMutableList()
        return when {
            remainingChars.size < size -> {
                null
            }
            else -> {
                var newStr = ""
                val newChars = mutableListOf<Char>()
                remainingChars.forEachIndexed { index, c ->
                    if (index < size) {
                        newStr+=c
                    }
                    else {
                        newChars.add(c)
                    }
                }
                val numRep = Integer.valueOf(newStr);
                if (numRep > 255 || (newStr.length > 1 && newStr[0] == '0')) {
                    return null
                }
                addressList.add(newStr)
                QueueItem(addressList,newChars.toCharArray())
            }
        }


    }

    private class QueueItem(val addressList : List<String> = listOf(), val remainingChars : CharArray)
}