package test

import solution.Solution26
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class Test26 : TestBase<Solution26.Solution>(Solution26.Solution()) {
    @Test
    fun test1() {
        val arr1 = intArrayOf(1,1,2)
        assertEquals(2, solution.removeDuplicates(arr1))
        assertContentEquals(intArrayOf(1,2), arr1.copyOf(2))

        val arr2 = intArrayOf(0,0,1,1,1,2,2,3,3,4)
        assertEquals(5, solution.removeDuplicates(arr2))
        assertContentEquals(intArrayOf(0,1,2,3,4), arr2.copyOf(5))

        val arr3 = intArrayOf(1)
        assertEquals(1, solution.removeDuplicates(arr3))
        assertContentEquals(intArrayOf(1), arr3.copyOf(1))

        val arr4 = intArrayOf(-1,0,1,2,3,4,5)
        assertEquals(7, solution.removeDuplicates(arr4))
        assertContentEquals(intArrayOf(-1,0,1,2,3,4,5), arr4.copyOf(7))

    }
}