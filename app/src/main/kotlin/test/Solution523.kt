package test

class Solution523 {
    class Solution {
        fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
            val sums = hashMapOf<Int, Int>()
            var curSum = 0
            for (i in 0..nums.size-1) {
                curSum += nums[i]
                val r = curSum%k
                if (i>0 && r==0) {
                    return true
                }
                if (sums.containsKey(r)) {
                    if (sums[r]!!<i) {
                        return true
                    }
                } else {
                    sums[r]=i+1
                }
            }
            return false
        }
    }
    // 5,0,0,0
    // 23,2,4,6,6
    // 7
//    4, 42, 3
}
