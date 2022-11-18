package test

import org.junit.Test
import solution.Solution263
import kotlin.test.assertEquals

class Test263 : TestBase<Solution263.Solution>(Solution263.Solution()) {
    @Test
    fun test() {
        assertEquals(true, solution.isUgly(6))
        assertEquals(true, solution.isUgly(1))
        assertEquals(false, solution.isUgly(14))
    }
}