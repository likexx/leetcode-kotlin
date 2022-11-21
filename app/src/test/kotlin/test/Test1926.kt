package test

import solution.Solution1926
import kotlin.test.Test
import kotlin.test.assertEquals

class Test1926 : TestBase<Solution1926.Solution>(Solution1926.Solution()) {

    @Test
    fun test() {
        val map1 = arrayOf(charArrayOf('+','+','.','+'),
            charArrayOf('.','.','.','+'),
            charArrayOf('+','+','+','.'))
        val entrance1 = intArrayOf(1,2)
        assertEquals(1, solution.nearestExit(map1, entrance1))

        val map2 = arrayOf(charArrayOf('+','+','+'),
            charArrayOf('.','.','.'),
            charArrayOf('+','+','+'))
        val entrance2 = intArrayOf(1,0)
        assertEquals(2, solution.nearestExit(map2, entrance2))

        val map3 = arrayOf(charArrayOf('.','+'))
        val entrance3 = intArrayOf(0,0)
        assertEquals(-1, solution.nearestExit(map3, entrance3))


    }

}