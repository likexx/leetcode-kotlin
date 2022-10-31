package test

class Solution1662 {
    class Solution {
        fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
            val sb1 = StringBuilder()
            val sb2 = StringBuilder()

            word1.forEach { sb1.append(it) }
            word2.forEach { sb2.append(it) }
            return sb1.toString().equals(sb2.toString())
        }
    }
}