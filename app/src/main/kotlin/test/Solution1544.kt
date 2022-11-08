package test

import test.annotation.Leetcode
import kotlin.math.abs

class Solution1544 {
    @Leetcode(1544)
    class Solution {
        fun makeGood(s: String): String {
            var indexes = mutableListOf<Int>()
            for (i in 0..s.length-1) {
                indexes.add(i)
            }

            val offset = kotlin.math.abs('A'-'a')

            while (true) {
                var hasBadLetters = false
                for (i in 0..indexes.size-2) {
                    if (kotlin.math.abs(s[indexes[i]]-s[indexes[i+1]])==offset) {
                        indexes.removeAt(i)
                        indexes.removeAt(i)
                        hasBadLetters=true
                        break
                    }
                }
                if (!hasBadLetters) {
                    break
                }
            }

            val builder = StringBuilder()
            for (i in indexes) {
                builder.append(s[i])
            }
            return builder.toString()
        }
    }
}