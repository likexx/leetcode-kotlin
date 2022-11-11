package test

import org.junit.Before
import solution.Solution1323
import kotlin.test.Test
import kotlin.test.*

class Test1323 : TestBase<Solution1323.Solution>(Solution1323.Solution()) {

    @Test
    fun test1() {
        val s = solution
        assertEquals(9999, s.maximum69Number(9996))
        assertEquals(9999, s.maximum69Number(9999))
        assertEquals(99999, s.maximum69Number(99969))
        assertEquals(99969, s.maximum69Number(96969))
        assertEquals(9969, s.maximum69Number(9669))
    }

    @Test
    fun test2() {
        val s = Solution1323.Solution()
        assertEquals(9999, s.maximum69NumberOriginal(9996))
        assertEquals(9999, s.maximum69NumberOriginal(9999))
        assertEquals(99999, s.maximum69NumberOriginal(99969))
        assertEquals(99969, s.maximum69NumberOriginal(96969))
        assertEquals(9969, s.maximum69NumberOriginal(9669))
    }

}
