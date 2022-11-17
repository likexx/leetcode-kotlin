package test

import org.junit.Test
import solution.Solution42
import kotlin.test.assertEquals

class Test42 : TestBase<Solution42.Solution>(Solution42.Solution()) {
    @Test
    fun test() {
        val tests = listOf(
            Pair(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1), 6),
            Pair(intArrayOf(4,2,0,3,2,5), 9)
        )

        for (t in tests) {
            assertEquals(t.second, solution.trap(t.first))
        }
    }
}