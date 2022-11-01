package test

import org.junit.Before
import kotlin.test.Test
import kotlin.test.*

class Test1239 {
    private val solution = Solution1239()

    @Before
    fun setup() {
        println("${solution.link} [${solution.level}]")
    }


    @Test 
    fun test() {
        val s = Solution1239.Solution()
        val tests = listOf(
            Pair(listOf("un","iq","ue"), 4),
            Pair(listOf("cha","r","act","ers"),6),
            Pair(listOf("abcdefghijklmnopqrstuvwxyz"), 26)
            )
        tests.forEach {
            assertEquals(it.second, s.maxLength(it.first))
        }
    }


}
