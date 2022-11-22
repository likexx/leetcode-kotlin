package test

import solution.Solution279
import kotlin.test.Test
import kotlin.test.assertEquals

class Test279 : TestBase<Solution279.Solution>(Solution279.Solution()) {
    @Test
    fun test() {
        assertEquals(solution.numSquaresNaive(12), solution.numSquares(12))
        assertEquals(solution.numSquaresNaive(13), solution.numSquares(13))
    }
}