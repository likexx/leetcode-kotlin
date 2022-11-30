package test

import solution.Solution1255
import kotlin.test.Test
import kotlin.test.assertEquals

class Test1255 : TestBase<Solution1255.Solution>(Solution1255.Solution()){
    @Test
    fun test() {
        assertEquals(23, solution.maxScoreWords(words = arrayOf("dog","cat","dad","good"),
                                                        letters = charArrayOf('a','a','c','d','d','d','g','o','o'),
                                                        score = intArrayOf(1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0)))

        assertEquals(27, solution.maxScoreWords(words = arrayOf("xxxz","ax","bx","cx"),
            letters = charArrayOf('z','a','b','c','x','x','x'),
            score = intArrayOf(4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10)))

        assertEquals(0, solution.maxScoreWords(words = arrayOf("leetcode"),
            letters = charArrayOf('l','e','t','c','o','d'),
            score = intArrayOf(4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10)))

    }
}