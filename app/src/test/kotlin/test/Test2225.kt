package test

import org.junit.Test
import solution.Solution2225
import kotlin.test.assertEquals

class Test2225 : TestBase<Solution2225.Solution>(Solution2225.Solution()) {
    @Test
    fun test() {
        val testData1 = arrayOf<IntArray>(intArrayOf(1,3),
            intArrayOf(2,3),
            intArrayOf(3,6),
            intArrayOf(5,6),
            intArrayOf(5,7),
            intArrayOf(4,5),
            intArrayOf(4,8),
            intArrayOf(4,9),
            intArrayOf(10,4),
            intArrayOf(10,9)
        )
        val expected1 = listOf<List<Int>>(listOf(1,2,10), listOf(4,5,7,8))
        assertEquals(expected1, solution.findWinners(testData1))

        // [2,3],[1,3],[5,4],[6,4]
        val testData2 = arrayOf<IntArray>(intArrayOf(2,3),
            intArrayOf(1,3),
            intArrayOf(5,4),
            intArrayOf(6,4)
        )
        val expected2 = listOf<List<Int>>(listOf(1,2,5,6), listOf())
        assertEquals(expected2, solution.findWinners(testData2))
    }
}