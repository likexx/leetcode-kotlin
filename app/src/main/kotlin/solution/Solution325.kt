package solution

import solution.annotation.Leetcode

class Solution325 {
    @Leetcode(325)
    class Solution {
        fun maxSubArrayLen(nums: IntArray, k: Int): Int {
            val indexes= mutableMapOf<Int, Int>()
            var curSum=0
            var maxLen=0
            for ((i, n) in nums.withIndex()) {
                curSum+=n
                if (curSum==k) {
                    maxLen=Math.max(maxLen, i+1)
                }
                val v1=curSum-k
                if (indexes.containsKey(v1)) {
                    maxLen=Math.max(maxLen, i-indexes[v1]!!)
                }

                if (!indexes.contains(curSum)) {
                    indexes[curSum]=i
                }
            }
            return maxLen
        }
    }
}