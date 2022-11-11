package test

import org.junit.Test
import solution.Solution41
import kotlin.test.assertEquals

class Test41 : TestBase<Solution41.Solution>(Solution41.Solution()) {
    @Test
    fun test() {
        val s = solution
        assertEquals(3, s.firstMissingPositive_Naive(intArrayOf(1,2,0)))
        assertEquals(2, s.firstMissingPositive_Naive(intArrayOf(3,4,-1,1)))
        assertEquals(1, s.firstMissingPositive_Naive(intArrayOf(7,8,9,11,12)))

        assertEquals(3, s.firstMissingPositive(intArrayOf(1,2,0)))
        assertEquals(2, s.firstMissingPositive(intArrayOf(3,4,-1,1)))
        assertEquals(1, s.firstMissingPositive(intArrayOf(7,8,9,11,12)))
    }
}