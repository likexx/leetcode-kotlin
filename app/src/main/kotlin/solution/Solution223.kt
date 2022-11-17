package solution

import solution.annotation.Leetcode

class Solution223 {
    @Leetcode(223)
    class Solution {
        fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
            var dx = if (ax1<bx2 && ax2>bx1) {
                kotlin.math.min(ax2, bx2) - kotlin.math.max(ax1,bx1)
            } else {
                0
            }

            val dy = if (ay1<by2 && ay2>by1) {
                kotlin.math.min(ay2, by2) - kotlin.math.max(ay1,by1)
            } else {
                0
            }
            val intersected = dx*dy

            return (ax2 - ax1)*(ay2 - ay1) + (bx2 - bx1)*(by2 - by1) - intersected
        }
    }
}