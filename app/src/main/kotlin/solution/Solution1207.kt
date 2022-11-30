package solution

import solution.annotation.Leetcode

class Solution1207 {
    @Leetcode(1207)
    class Solution {
        fun uniqueOccurrences(arr: IntArray): Boolean {
            val occurences = hashMapOf<Int, Int>()
            for (n in arr) {
                occurences[n] = occurences.getOrDefault(n, 0) + 1
            }

            val count = hashSetOf<Int>()
            for (c in occurences.values) {
                if (count.contains(c)) {
                    return false
                }
                count.add(c)
            }
            return true
        }
    }
}