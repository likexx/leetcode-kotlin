package solution

import solution.annotation.Leetcode

class Solution26 {
    @Leetcode(26)
    class Solution {
        fun removeDuplicates(nums: IntArray): Int {
            var lastDuplicatedIndex = -1
            for (i in 1..nums.size-1) {
                if (nums[i]==nums[i-1] && lastDuplicatedIndex==-1) {
                    lastDuplicatedIndex = i
                } else if (nums[i]!=nums[i-1] && lastDuplicatedIndex != -1){
                    nums[lastDuplicatedIndex] = nums[i]
                    lastDuplicatedIndex+=1
                }
            }
            return if (lastDuplicatedIndex==-1) {nums.size} else lastDuplicatedIndex
        }
    }
}