package solution

class ListNode(`val`:Int) {
    var next: ListNode? = null
    var value = 0

    init {
        value = `val`
    }
}

fun buildList(vararg arr: Int): ListNode? {
    var firstNode: ListNode? = null
    var prevNode: ListNode? = null

    for (v in arr) {
        val cur = ListNode(v)
        if (firstNode == null) {
            firstNode = cur
            prevNode = cur
        } else {
            prevNode!!.next = cur
            prevNode = cur
        }
    }

    return firstNode
}

fun iterateList(head: ListNode?) : List<Int> {
    val list = mutableListOf<Int>()
    if (head != null) {
        var p = head
        while (p!=null) {
            list.add(p.value)
            p = p.next
        }
    }
    return list
}