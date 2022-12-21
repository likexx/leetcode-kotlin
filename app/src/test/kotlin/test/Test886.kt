package test

import solution.Solution886
import kotlin.test.Test
import kotlin.test.assertEquals

class Test886 : TestBase<Solution886.Solution>(Solution886.Solution()) {
    @Test
    fun test() {
        assertEquals(true, solution.possibleBipartition(4, arrayOf(intArrayOf(1,2), intArrayOf(1,3), intArrayOf(2,4))))
        assertEquals(false, solution.possibleBipartition(4, arrayOf(intArrayOf(1,2), intArrayOf(1,3), intArrayOf(2,3))))
        assertEquals(false, solution.possibleBipartition(5, arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(4,5), intArrayOf(1,5))))
    }
}