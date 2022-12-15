package test

import org.junit.Test
import solution.Solution1143
import kotlin.test.assertEquals

class Test1143 : TestBase<Solution1143.Solution>(Solution1143.Solution()) {
    @Test
    fun test() {
//        assertEquals(3, solution.longestCommonSubsequence(text1 = "abcde", text2 = "ace" ))
        assertEquals(3, solution.longestCommonSubsequence(text1 = "abcde", text2 = "ace" ))
//        assertEquals(0, solution.longestCommonSubsequence(text1 = "abc", text2 = "def" ))
        assertEquals(1, solution.longestCommonSubsequence(text1 = "bsbininm", text2 = "jmjkbkjkv" ))

    }
}