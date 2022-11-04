package test

import test.annotation.Leetcode

class Solution345 {
    @Leetcode(345)
    class Solution {
        fun reverseVowels(s: String): String {
            val vowels = setOf('a','e','i','o','u','A','E','I','O','U')
            val chars = s.toCharArray()
            var i=0
            var j=chars.size-1
            while (i<j) {
                while (i<j && !vowels.contains(chars[i])) {
                    i+=1
                }
                while (i<j && !vowels.contains(chars[j])) {
                    j-=1
                }
                if (i<j) {
                    val t=chars[i]
                    chars[i]=chars[j]
                    chars[j]=t
                    i+=1
                    j-=1
                }
            }

            return chars.joinToString("")
        }
    }
}