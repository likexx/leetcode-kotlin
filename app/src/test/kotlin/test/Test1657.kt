package test

import solution.Solution1657
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Test1657 : TestBase<Solution1657.Solution>(Solution1657.Solution()) {
    @Test
    fun test() {
        assertTrue { solution.closeStrings(word1 = "abc", word2 = "bca") }
        assertFalse { solution.closeStrings(word1 = "a", word2 = "aa") }
        assertTrue { solution.closeStrings(word1 = "cabbba", word2 = "abbccc") }
        assertFalse { solution.closeStrings(word1 = "uau", word2 = "ssx") }
    }
}