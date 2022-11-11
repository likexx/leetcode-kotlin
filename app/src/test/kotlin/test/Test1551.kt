package test

import solution.Solution1551
import kotlin.test.Test
import kotlin.test.assertEquals

class Test1551 : TestBase<Solution1551.Solution>(Solution1551.Solution()){
    @Test
    fun test() {
        assertEquals(2, solution.minOperationsLoop(3))
        assertEquals(9, solution.minOperationsLoop(6))

        for (i in 1..20) {
            assertEquals(solution.minOperationsLoop(i), solution.minOperations(i))
        }
    }
}