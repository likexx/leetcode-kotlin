package test

import solution.buildTree
import solution.iterateTreeByLevel
import kotlin.test.Test
import kotlin.test.assertContentEquals


class TestTreeNode {
    @Test
    fun test() {
        var tree = buildTree(1,2,3,null,5,6)
        assertContentEquals(arrayOf(1,2,3,null,5,6), iterateTreeByLevel(tree))

        tree = buildTree(1,2,3,null,null,6,7)
        assertContentEquals(arrayOf(1,2,3,null,null,6,7), iterateTreeByLevel(tree))

    }
}