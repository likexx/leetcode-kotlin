package test

import org.junit.Before
import solution.Solution952
import kotlin.test.Test
import kotlin.test.*

class Test952 : TestBase<Solution952.Solution>(Solution952.Solution()) {

    @Test
    fun test1() {
        val s = solution
        assertEquals(4, s.largestComponentSize(intArrayOf(4,6,15,35)))
        assertEquals(2, s.largestComponentSize(intArrayOf(20,50,9,63)))
        assertEquals(8, s.largestComponentSize(intArrayOf(2,3,6,7,4,12,21,39)))
    }

}
