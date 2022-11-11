package solution

import solution.annotation.Leetcode

class Solution1003 {
    @Leetcode(1003)
    class Solution {
        fun isValid(s: String): Boolean {
            // hint: use stack, a must be before b, and b must be before c
            val stack = mutableListOf<Char>()
            for (c in s) {
                when (c) {
                    'a' -> { stack.add(c) }
                    'b' -> {
                        if (stack.size==0 || stack.last()!='a') {
                            return false
                        }
                        stack.removeAt(stack.size-1)
                        stack.add(c)
                    }
                    'c' -> {
                        if (stack.size==0 || stack.last()!='b') {
                            return false
                        }
                        stack.removeAt(stack.size-1)
                    }
                    else -> {
                        return false
                    }
                }
            }
            return stack.size==0
        }

        fun isValid_Naive(s: String): Boolean {
            val pattern = "abc"

            var s1=s
            var s2=s1.replace(pattern, "")
            while (s1.length!=s2.length) {
                s1=s2
                s2=s1.replace(pattern, "")
            }
            return s2.length==0
        }
    }
}