package test

import solution.Solution938
import solution.buildTree
import kotlin.test.Test
import kotlin.test.assertEquals

class Test938 : TestBase<Solution938.Solution>(Solution938.Solution()) {
    @Test
    fun test() {
        val tree1 = buildTree(10,5,15,3,7,null,18)
        assertEquals(32, solution.rangeSumBST(tree1, 7, 15))

        val tree2 = buildTree(10,5,15,3,7,13,18,1,null,6)
        assertEquals(23, solution.rangeSumBST(tree2, 6, 10))
    }
}