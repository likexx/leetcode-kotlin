package test

import org.junit.Test
import solution.Solution2130
import kotlin.test.assertEquals
import solution.buildList as buildList

class Test2130 : TestBase<Solution2130.Solution>(Solution2130.Solution()) {
    @Test
    fun test() {
        assertEquals(6, solution.pairSum(buildList(5,4,2,1)))
        assertEquals(7, solution.pairSum(buildList(4,2,2,3)))
        assertEquals(100001, solution.pairSum(buildList(1,100000)))
    }
}