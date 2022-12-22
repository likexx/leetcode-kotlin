package test

import solution.Solution834
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class Test834 : TestBase<Solution834.Solution>(Solution834.Solution()){
    @Test
    fun test() {
        assertContentEquals(intArrayOf(8,12,6,10,10,10), solution.sumOfDistancesInTree(6, arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(2,3), intArrayOf(2,4), intArrayOf(2,5))))
        assertContentEquals(intArrayOf(1,1), solution.sumOfDistancesInTree(2, arrayOf(intArrayOf(1,0))))
    }
}