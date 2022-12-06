package test

import solution.Solution328
import kotlin.test.Test
import kotlin.test.assertContentEquals
import solution.buildList as buildList
import solution.iterateList as iterateList

class Test328 : TestBase<Solution328.Solution>(Solution328.Solution()) {
    @Test
    fun test() {
        assertContentEquals(listOf(1,3,5,2,4), iterateList(solution.oddEvenList(buildList(1,2,3,4,5))))
        assertContentEquals(listOf(2,3,6,7,1,5,4), iterateList(solution.oddEvenList(buildList(2,1,3,5,6,4,7))))
    }
}