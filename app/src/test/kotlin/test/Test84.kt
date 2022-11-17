package test

import org.junit.Test
import solution.Solution84
import kotlin.test.assertEquals

class Test84 : TestBase<Solution84.Solution>(Solution84.Solution()) {
    @Test
    fun test() {
        assertEquals(10, solution.largestRectangleArea(intArrayOf(2,1,5,6,2,3)))
        assertEquals(4, solution.largestRectangleArea(intArrayOf(2,4)))
    }
}