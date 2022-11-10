package test

import org.junit.Test
import kotlin.test.assertEquals

class Test1003 : TestBase<Solution1003.Solution>(Solution1003.Solution()) {

    @Test
    fun test() {
        val s = Solution1003.Solution()
        assertEquals(s.isValid_Naive("abc"), s.isValid("abc"))
        assertEquals(s.isValid_Naive("aabcbc"), s.isValid("aabcbc"))
        assertEquals(s.isValid_Naive("abcabcababcc"), s.isValid("abcabcababcc"))
        assertEquals(s.isValid_Naive("abccba"), s.isValid("abccba"))
    }

}