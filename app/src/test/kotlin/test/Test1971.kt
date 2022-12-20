package test

import solution.Solution1971
import kotlin.test.Test
import kotlin.test.assertEquals

class Test1971 : TestBase<Solution1971.Solution>(Solution1971.Solution()) {
    @Test
    fun test() {
//        assertEquals(true, solution.validPath(3, arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(2,0)), 0, 2))
//        assertEquals(true, solution.validPath(10, arrayOf(
//            intArrayOf(4,3),
//            intArrayOf(1,4),
//            intArrayOf(4,8),
//            intArrayOf(1,7),
//            intArrayOf(6,4),
//            intArrayOf(4,2),
//            intArrayOf(7,4),
//            intArrayOf(4,0),
//            intArrayOf(0,9),
//            intArrayOf(5,4)),
//            5, 9))
        assertEquals(true, solution.validPath(10, arrayOf(
            intArrayOf(0,7),
            intArrayOf(0,8),
            intArrayOf(6,1),
            intArrayOf(2,0),
            intArrayOf(0,4),
            intArrayOf(5,8),
            intArrayOf(4,7),
            intArrayOf(1,3),
            intArrayOf(3,5),
            intArrayOf(6,5)),
            7, 5))

    }
}