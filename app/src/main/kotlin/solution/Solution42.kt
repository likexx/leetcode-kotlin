package solution

import solution.annotation.Leetcode

class Solution42 {
    @Leetcode(42)
    class Solution {
        fun trap(height: IntArray): Int {
            val s = mutableListOf<Int>()
            var water = 0
            for (i in height.indices) {
                while (s.size > 0 && height[s.last()]<=height[i]) {
                    val j = s.last()
                    s.removeAt(s.size-1)
                    if (s.size > 0) {
                        val h = kotlin.math.min(height[i], height[s.last()]) - height[j]
                        val w = i-s.last()-1
                        water += h*w
                    }
                }
                s.add(i)
            }
            return water
        }
    }
}