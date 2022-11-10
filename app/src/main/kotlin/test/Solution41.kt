package test

import test.annotation.Leetcode

class Solution41 {
    @Leetcode(41)
    class Solution {
        fun firstMissingPositive(nums: IntArray): Int {
            // use sign to indicate if i exists
            val N = nums.size
            var hasOne = false
            for (n in nums) {
                if (n==1) {
                    hasOne = true
                    break
                }
            }
            if (!hasOne) {
                return 1
            }

            for (i in nums.indices) {
                if (nums[i]<=0 || nums[i]>N) {
                    nums[i]=1
                }
            }

            for (i in 0..N-1) {
                val n = kotlin.math.abs(nums[i])

                if (n==N) {
                    nums[0]=-kotlin.math.abs(nums[0])
                } else {
                    nums[n]=-kotlin.math.abs(nums[n])
                }
            }

            for (i in 2..N-1) {
                if (nums[i]>0) {
                    return i
                }
            }
            if (nums[0]>0) {
                return N
            }

            return N+1
        }

        fun firstMissingPositive_Naive(nums: IntArray): Int {
            val values = hashSetOf<Int>()
            var maxValue = kotlin.Int.MIN_VALUE
            for (n in nums) {
                maxValue = kotlin.math.max(n, maxValue)
                values.add(n)
            }

            var i=1
            while (i<maxValue+1) {
                if (!values.contains(i)) {
                    return i
                }
                i+=1
            }
            return i
        }

    }
}