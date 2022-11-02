package test

import org.junit.Test
import kotlin.test.assertEquals

class Test433 : TestBase<Solution433.Solution>(Solution433.Solution()) {
    @Test
    fun test() {
        assertEquals(1, solution.minMutation("AACCGGTT", "AACCGGTA", arrayOf("AACCGGTA")))
        assertEquals(2, solution.minMutation("AACCGGTT", "AAACGGTA", arrayOf("AACCGGTA", "AACCGCTA", "AAACGGTA")))
        assertEquals(3, solution.minMutation("AAAAACCC", "AACCCCCC", arrayOf("AAAACCCC", "AAACCCCC", "AACCCCCC")))

    }
}