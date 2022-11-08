package test

import org.junit.Test
import kotlin.test.assertEquals

class Test1544 : TestBase<Solution1544.Solution>(Solution1544.Solution()) {

    @Test
    fun test() {
        val s = Solution1544.Solution()
        assertEquals("leetcode", s.makeGood("leEeetcode"))
        assertEquals("", s.makeGood("abBAcC"))
        assertEquals("s", s.makeGood("s"))
    }

}