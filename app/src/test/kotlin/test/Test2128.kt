package test

import solution.Solution2128
import kotlin.test.Test
import kotlin.test.assertEquals

class Test2128 : TestBase<Solution2128.Solution>(Solution2128.Solution()) {
    @Test
    fun test() {
        assertEquals(true, solution.removeOnes(arrayOf(intArrayOf(0,1,0), intArrayOf(1,0,1), intArrayOf(0,1,0))))
        assertEquals(false, solution.removeOnes(arrayOf(intArrayOf(1,1,0), intArrayOf(0,0,0), intArrayOf(0,0,0))))
        assertEquals(true, solution.removeOnes(arrayOf(intArrayOf(0))))
        assertEquals(false, solution.removeOnes(arrayOf(intArrayOf(0,0), intArrayOf(0, 1))))
    }
}