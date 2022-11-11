package test

import org.junit.Test
import solution.Solution1047
import kotlin.test.assertEquals

class Test1047 : TestBase<Solution1047.Solution>(Solution1047.Solution()) {

    @Test
    fun test1() {
        val s = Solution1047.Solution()
        assertEquals("ca", s.removeDuplicates("abbaca"))
        assertEquals("ay", s.removeDuplicates("azxxzy"))
    }

}