package solution

import solution.annotation.Leetcode

class Solution84 {
    @Leetcode(84)
    class Solution {
        fun largestRectangleArea(heights: IntArray): Int {
            val s = mutableListOf<Int>()
            s.add(-1)
            var maxArea = 0
            for (i in heights.indices) {
                while (s.last() != -1 && heights[s.last()] > heights[i]) {
                    val j = s.last()
                    s.removeAt(s.size-1)
                    val w = i-1 - s.last()
                    val h = heights[j]
                    maxArea = kotlin.math.max(maxArea, w*h)
                }
                s.add(i)
            }

            val N = heights.size
            for (i in s.size-1 downTo 1) {
                maxArea = kotlin.math.max(maxArea, heights[s[i]] * (N-1 - s[i-1]))
            }

            return maxArea
        }
    }
}