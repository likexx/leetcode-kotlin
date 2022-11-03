package test

import org.junit.Before
import kotlin.test.Test
import kotlin.test.*

class Test2131 : TestBase<Solution2131.Solution>(Solution2131.Solution()) {
    @Test
    fun test() {
        assertEquals(6, solution.longestPalindrome(arrayOf("lc","cl","gg")))
        assertEquals(8, solution.longestPalindrome(arrayOf("ab","ty","yt","lc","cl","ab")))
        assertEquals(2, solution.longestPalindrome(arrayOf("cc","ll","xx")))
    }

}
