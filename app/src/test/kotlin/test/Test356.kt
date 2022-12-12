package test

import solution.Solution356
import kotlin.test.Test
import kotlin.test.assertEquals

class Test356 : TestBase<Solution356.Solution>(Solution356.Solution()) {
    @Test
    fun test() {
//        assertEquals(true, solution.isReflected(arrayOf(intArrayOf(1, 1), intArrayOf(-1,1))))
//        assertEquals(false, solution.isReflected(arrayOf(intArrayOf(1, 1), intArrayOf(-1,-1))))
//        // [[-16,1],[16,1],[16,1]]
//        assertEquals(true, solution.isReflected(arrayOf(intArrayOf(-16,1), intArrayOf(16,1), intArrayOf(16,1))))
//        // [[1,2],[2,2],[1,4],[2,4]]
//        assertEquals(true, solution.isReflected(arrayOf(intArrayOf(1,2), intArrayOf(2,2), intArrayOf(1,4), intArrayOf(2,4))))
        // [[0,0],[1,0],[3,0]]
        assertEquals(false, solution.isReflected(arrayOf(intArrayOf(0,0), intArrayOf(1,0), intArrayOf(3,0))))
    }
}