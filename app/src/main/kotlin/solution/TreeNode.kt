package solution

import com.sun.source.tree.Tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var value = 0

    init {
        value = `val`
    }
}

fun buildTree(vararg  values: Int?) : TreeNode? {
    if (values.isEmpty()) {
        return null
    }

    val nodes = mutableListOf<TreeNode?>()
    values.forEach {
        if (it == null) {
            nodes.add(null)
        } else {
            nodes.add(TreeNode(it))
        }
    }

    val q = mutableListOf<TreeNode?>()
    var i = 0
    val root = nodes[i]
    i+=1
    q.add(root!!)

    while (q.isNotEmpty()) {
        val p = q.first()
        q.removeAt(0)
        if (p == null) {
            continue
        }

        p.left = if (i < nodes.size) { nodes[i] } else { null }
        p.right = if (i+1 < nodes.size) { nodes[i+1] } else { null }
        i += 2
        q.add(p.left)
        q.add(p.right)
    }

    return root
}

fun iterateTreeByLevel(root: TreeNode?): Array<Int?> {
    val result = mutableListOf<Int?>()
    val q = mutableListOf<TreeNode?>()
    q.add(root)
    while (q.isNotEmpty()) {
        val p = q.first()
        q.removeAt(0)
        if (p==null) {
            result.add(null)
        } else {
            result.add(p.value)
            q.add(p.left)
            q.add(p.right)
        }
    }
    while (result.last() == null) {
        result.removeAt(result.size - 1)
    }

    return result.toTypedArray()
}