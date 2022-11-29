package test

import solution.Solution380
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Test380 : TestBase<Solution380.RandomizedSet>(Solution380.RandomizedSet()) {
    @Test
    fun test() {
        assertEquals(true, solution.insert(1))
        assertEquals(false, solution.remove(2))
        assertEquals(true, solution.insert(2))
        assertTrue { val v = solution.getRandom(); v==1 || v==2 }
        assertEquals(2, solution.getRandom())
        assertEquals(true, solution.remove(1))
        assertEquals(false, solution.insert(2))
        assertEquals(2, solution.getRandom())
    }
}