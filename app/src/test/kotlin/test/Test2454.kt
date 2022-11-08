package test

import org.junit.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class Test2454 : TestBase<Solution2454.Solution>(Solution2454.Solution()) {

    @Test
    fun test1() {
        val s = Solution2454.Solution()
        assertContentEquals(intArrayOf(-1,-1), s.secondGreaterElementNaive(intArrayOf(3,3)))
        assertContentEquals(intArrayOf(9,6,6,-1,-1), s.secondGreaterElementNaive(intArrayOf(2,4,0,9,6)))
    }

    @Test
    fun test2() {
        val s = Solution2454.Solution()
        assertContentEquals(intArrayOf(-1,-1), s.secondGreaterElementOriginal(intArrayOf(3,3)))
        assertContentEquals(intArrayOf(9,6,6,-1,-1), s.secondGreaterElementOriginal(intArrayOf(2,4,0,9,6)))
        assertContentEquals(intArrayOf(-1,-1), s.secondGreaterElementOriginal(intArrayOf(3,3)))
        assertContentEquals(s.secondGreaterElementNaive(intArrayOf(7,7,7,7,7,7,7,7,7,7,8)),
                            s.secondGreaterElementOriginal(intArrayOf(7,7,7,7,7,7,7,7,7,7,8)))
    }

    @Test
    fun test3() {
        val s = Solution2454.Solution()
        assertContentEquals(intArrayOf(-1,-1), s.secondGreaterElement(intArrayOf(3,3)))
        assertContentEquals(intArrayOf(9,6,6,-1,-1), s.secondGreaterElement(intArrayOf(2,4,0,9,6)))
        assertContentEquals(intArrayOf(-1,-1), s.secondGreaterElement(intArrayOf(3,3)))
        assertContentEquals(s.secondGreaterElementNaive(intArrayOf(7,7,7,7,7,7,7,7,7,7,8)),
            s.secondGreaterElement(intArrayOf(7,7,7,7,7,7,7,7,7,7,8)))
        assertContentEquals(s.secondGreaterElementNaive(intArrayOf(11,13,15,12,0,15,12,11,9)),
            s.secondGreaterElement(intArrayOf(11,13,15,12,0,15,12,11,9)))
    }

}