package test

import org.junit.Test
import solution.Solution914
import kotlin.test.assertEquals

class Test914 : TestBase<Solution914.Solution>(Solution914.Solution()) {
    @Test
    fun test() {
//        assertEquals(true, solution.hasGroupsSizeX(intArrayOf(1,2,3,4,4,3,2,1)))
//        assertEquals(false, solution.hasGroupsSizeX(intArrayOf(1,1,1,2,2,2,3,3)))
//        assertEquals(false, solution.hasGroupsSizeX(intArrayOf(1,1,1,1,1,0,0,0)))
        assertEquals(true, solution.hasGroupsSizeX(intArrayOf(1,1,1,1,2,2,2,2,2,2)))
        assertEquals(false, solution.hasGroupsSizeX(intArrayOf(1)))
    }
}