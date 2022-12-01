package test

import solution.Solution1392
import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class Test1392 : TestBase<Solution1392.Solution>(Solution1392.Solution()){
    @Test
    fun test() {
        assertEquals("l", solution.longestPrefix("level"))
        assertEquals("abab", solution.longestPrefix("ababab"))
        assertEquals("", solution.longestPrefix("bba"))
        assertEquals("ac", solution.longestPrefix("acccbaaacccbaac"))
    }
}