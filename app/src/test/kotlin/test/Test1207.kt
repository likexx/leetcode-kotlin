package test

import org.junit.Test
import solution.Solution1207
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Test1207 : TestBase<Solution1207.Solution>(Solution1207.Solution()){
    @Test
    fun test() {
        assertTrue { solution.uniqueOccurrences(intArrayOf(1,2,2,1,1,3)) }
        assertFalse { solution.uniqueOccurrences(intArrayOf(1,2)) }
        assertTrue { solution.uniqueOccurrences(intArrayOf(-3,0,1,-3,1,1,1,-3,10,0)) }

    }

}