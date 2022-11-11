package solution

import solution.annotation.Leetcode

class Solution1047 {
    @Leetcode(1047)
    class Solution {
        fun removeDuplicates(s: String): String {
            val stack = mutableListOf<Char>()

            for (c in s) {
                if (stack.size>0 && c==stack.last()) {
                    stack.removeAt(stack.size-1)
                } else {
                    stack.add(c)
                }
            }

            return stack.joinToString("")
        }
    }
}