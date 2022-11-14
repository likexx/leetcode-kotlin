package test

import org.junit.Test
import solution.Solution947
import kotlin.test.assertEquals

class Test947 : TestBase<Solution947.Solution>(Solution947.Solution()) {
    @Test
    fun test1() {
        val tests = arrayListOf<Pair<Array<IntArray>, Int>>(
            Pair(arrayOf(intArrayOf(0,0), intArrayOf(0,1), intArrayOf(1,0),intArrayOf(1,2), intArrayOf(2,1), intArrayOf(2,2)), 5),
            Pair(arrayOf(intArrayOf(0,0), intArrayOf(0,2), intArrayOf(1,1),intArrayOf(2,0), intArrayOf(2,2)), 3),
            Pair(arrayOf(intArrayOf(0,0)), 0),
            Pair(arrayOf(intArrayOf(0,0), intArrayOf(0,2), intArrayOf(1,1), intArrayOf(2,0), intArrayOf(2,2)), 3),
            Pair(arrayOf(intArrayOf(0,1), intArrayOf(1,0), intArrayOf(1,1)), 2),
            Pair(arrayOf(intArrayOf(0,0), intArrayOf(0,1), intArrayOf(1,0), intArrayOf(1,1), intArrayOf(2,1), intArrayOf(2,2),
                intArrayOf(3,2), intArrayOf(3,3), intArrayOf(3,4), intArrayOf(4,3), intArrayOf(4,4)), 10)
        )

        for (t in tests) {
            assertEquals(t.second, solution.removeStonesNaive(t.first))
        }

        for (t in tests) {
            assertEquals(t.second, solution.removeStonesDFS(t.first))
        }

        for (t in tests) {
            assertEquals(t.second, solution.removeStones(t.first))
        }

    }

}