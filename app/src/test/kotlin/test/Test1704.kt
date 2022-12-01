package test

import solution.Solution1704
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Test1704 : TestBase<Solution1704.Solution>(Solution1704.Solution()) {
    @Test
    fun test() {
        assertTrue { solution.halvesAreAlike("book") }
        assertFalse { solution.halvesAreAlike("textbook")}
        assertTrue { solution.halvesAreAlike("AbCdEfGh") }
    }
}