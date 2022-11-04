package test

import org.junit.Test
import kotlin.test.assertEquals

class Test345 : TestBase<Solution345.Solution>(Solution345.Solution()) {
    @Test
    fun test() {
        assertEquals("aeiou", solution.reverseVowels("uoiea"))
        assertEquals("aeIoU", solution.reverseVowels("UoIea"))
        assertEquals("I love u", solution.reverseVowels("u levo I"))
        assertEquals("holle", solution.reverseVowels("hello"))
        assertEquals("holle", solution.reverseVowels("hello"))
        assertEquals("leotcede", solution.reverseVowels("leetcode"))
    }
}