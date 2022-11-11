package test

import org.junit.Test
import solution.Solution1544
import kotlin.test.assertEquals

class Test1544 : TestBase<Solution1544.Solution>(Solution1544.Solution()) {

    @Test
    fun test() {
        val s = solution
        assertEquals("leetcode", s.makeGood("leEeetcode"))
        assertEquals("", s.makeGood("abBAcC"))
        assertEquals("s", s.makeGood("s"))
    }

}