package test

import solution.Solution357
import kotlin.test.Test
import kotlin.test.assertEquals

class Test357 : TestBase<Solution357.Solution>(Solution357.Solution()) {
    @Test
    fun test() {
        assertEquals(91, solution.countNumbersWithUniqueDigits(2))
        assertEquals(1, solution.countNumbersWithUniqueDigits(0))
        assertEquals(739, solution.countNumbersWithUniqueDigits(3))
    }
}