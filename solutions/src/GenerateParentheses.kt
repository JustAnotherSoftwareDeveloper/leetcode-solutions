class GenerateParentheses {

    fun generateParenthesis(n: Int): List<String> {
        val root = ParanNode("")
        traverse(root,n,n)
        val allStrings = mutableSetOf<String>()
        getStringsFromTree(root,"",allStrings)
        return allStrings.toList()
    }

    private fun traverse(node: ParanNode, openAvailable: Int, closedAvailable: Int) : Unit {
        var toAdd : ParanNode
        println("$openAvailable : $closedAvailable")
        if (openAvailable == 0 && closedAvailable == 0) {
            return
        }
        else if (openAvailable == 0) {
            toAdd = ParanNode(")")
            node.children.add(toAdd)
            traverse(toAdd,openAvailable,closedAvailable-1)
        }
        else if (openAvailable - closedAvailable == 0) {
            toAdd = ParanNode("(")
            node.children.add(toAdd)
            traverse(toAdd,openAvailable-1,closedAvailable)
        }
        else {
            toAdd = ParanNode("(")
            node.children.add(toAdd)
            traverse(toAdd,openAvailable-1,closedAvailable)
            toAdd = ParanNode(")")
            node.children.add(toAdd)
            traverse(toAdd,openAvailable,closedAvailable-1)
        }
    }
    private fun getStringsFromTree(node: ParanNode, currentString: String, allStrings: MutableSet<String>) {
        val newString = currentString+node.paren
        if (node.children.isEmpty()) {
            println("End of Line")
            allStrings.add(newString)
        }
        else {

            node.children.forEach{getStringsFromTree(it,newString,allStrings)}
        }
    }

    private data class ParanNode(val paren: String, val children : MutableList<ParanNode> = mutableListOf())
}