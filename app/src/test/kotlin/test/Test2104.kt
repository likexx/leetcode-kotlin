package test

import org.junit.Test
import kotlin.test.assertEquals

class Test2104 : TestBase<Solution2104.Solution>(Solution2104.Solution()) {

    @Test
    fun test1() {
        val s = Solution2104.Solution()
        assertEquals(4, s.subArrayRangesNaive(intArrayOf(1,2,3)))
        assertEquals(4, s.subArrayRangesNaive(intArrayOf(1,3,3)))
        assertEquals(59, s.subArrayRangesNaive(intArrayOf(4,-2,-3,4,1)))
    }

    @Test
    fun test2() {
        val s = Solution2104.Solution()
        assertEquals(s.subArrayRangesNaive(intArrayOf(1,2,3)), s.subArrayRanges(intArrayOf(1,2,3)))
        assertEquals(s.subArrayRangesNaive(intArrayOf(1,3,3)), s.subArrayRanges(intArrayOf(1,3,3)))
        assertEquals(s.subArrayRangesNaive(intArrayOf(4,-2,-3,4,1)), s.subArrayRanges(intArrayOf(4,-2,-3,4,1)))
    }

}
