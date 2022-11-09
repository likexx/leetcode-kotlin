package test

import org.junit.Test
import kotlin.test.assertEquals

class Test901 : TestBase<Solution901.StockSpanner>(Solution901.StockSpanner()) {

    @Test
    fun test1() {
        val s = Solution901.StockSpanner()
        assertEquals(1, s.next(100))
        assertEquals(1, s.next(80))
        assertEquals(1, s.next(60))
        assertEquals(2, s.next(70))
        assertEquals(1, s.next(60))
        assertEquals(4, s.next(75))
        assertEquals(6, s.next(85))
    }

}
