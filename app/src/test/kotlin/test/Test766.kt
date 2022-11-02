package test

import kotlin.test.Test
import kotlin.test.*

class Test766 : TestBase<Solution766.Solution>(Solution766.Solution()) {
    @Test
    fun test() {
        val tests = listOf(
            Pair(arrayOf(intArrayOf(1,2,3,4),intArrayOf(5,1,2,3),intArrayOf(9,5,1,2)), true),
            Pair(arrayOf(intArrayOf(1,2), intArrayOf(2,2)), false),
            )

        tests.forEach {
            assertEquals(it.second, solution.isToeplitzMatrix(it.first))
        }
    }
    
}
