package test

import org.junit.Test
import solution.Solution223
import kotlin.test.assertEquals

class Test223 : TestBase<Solution223.Solution>(Solution223.Solution()){
    @Test
    fun test() {
        assertEquals(45, solution.computeArea(ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2))
        assertEquals(16, solution.computeArea(ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2))
    }
}