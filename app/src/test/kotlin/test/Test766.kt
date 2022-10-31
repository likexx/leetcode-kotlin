package test

import org.junit.Before
import kotlin.test.Test
import kotlin.test.*

class Test766 {
    val solution = Solution766()

    @Before
    fun setup() {
        println("${solution.link} [${solution.level}]")
    }

    @Test 
    fun test() {
        val s = Solution766.Solution()
        val tests = listOf(
            Pair(arrayOf(intArrayOf(1,2,3,4),intArrayOf(5,1,2,3),intArrayOf(9,5,1,2)), true),
            Pair(arrayOf(intArrayOf(1,2), intArrayOf(2,2)), false),
            )

        tests.forEach {
            assertEquals(it.second, s.isToeplitzMatrix(it.first))
        }
    }
    
}
