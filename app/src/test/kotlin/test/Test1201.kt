package test

import org.junit.Test
import solution.Solution1201
import kotlin.test.assertEquals

class Test1201 : TestBase<Solution1201.Solution>(Solution1201.Solution()) {
    @Test
    fun test() {
        assertEquals(4, solution.nthUglyNumber(n = 3, a = 2, b = 3, c = 5))
        assertEquals(6, solution.nthUglyNumber(n = 4, a = 2, b = 3, c = 4))
        assertEquals(10, solution.nthUglyNumber(n = 5, a = 2, b = 11, c = 13))
        assertEquals(1999999984, solution.nthUglyNumber(1000000000,2,217983653,336916467))
        assertEquals(1, solution.nthUglyNumber(1,1,1,1))
    }

}