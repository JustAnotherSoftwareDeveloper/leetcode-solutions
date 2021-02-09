class KeysAndRooms {

    fun canVisitAllRooms(rooms: List<List<Int>>) : Boolean {
        val visited = mutableSetOf<Int>()

        val queue = mutableListOf(0)
        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0);
            visited.add(current);
            queue.addAll(rooms[current].filter { !visited.contains(it) })
        }
        return visited.size == rooms.size
    }
}