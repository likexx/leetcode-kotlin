package test

import solution.ListNode
import solution.buildList as buildList
import solution.Solution876
import kotlin.test.Test
import kotlin.test.assertEquals

class Test876 : TestBase<Solution876.Solution>(Solution876.Solution()){
    @Test
    fun test() {
        assertEquals(3, solution.middleNode(buildList(1,2,3,4,5))!!.value)
        assertEquals(4, solution.middleNode(buildList(1,2,3,4,5,6))!!.value)
    }
}