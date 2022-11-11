package solution

import solution.annotation.Leetcode

class Solution2104 {
    @Leetcode(2104)
    class Solution {
        fun subArrayRanges(nums: IntArray): Long {
            // monolithic stacks
            // sum = sum(all maxes) - sum(all mins)
            val N = nums.size
            var sum: Long = 0

            // maxes should be decremental, each maxes.last() should be the peak point in subarrays
            val maxes = mutableListOf<Int>()
            for (i in 0..N) {
                while (maxes.size > 0 && (i==N || nums[maxes.last()]<=nums[i])) {
                    val last = maxes.removeAt(maxes.size-1)
                    val left = if (maxes.size>0) { maxes.last() } else -1
                    sum += (last-left)*(i-last)*(nums[last].toLong())
                }
                maxes.add(i)
            }

            // mins should be increment. each mins.last() should be the bottom of all subarrays
            val mins = mutableListOf<Int>()
            for (i in 0..N) {
                while (mins.size > 0 && (i==N || nums[mins.last()]>=nums[i])) {
                    val last = mins.removeAt(mins.size-1)
                    val left = if (mins.size>0) {mins.last()} else -1
                    sum -= (last-left)*(i-last)*nums[last].toLong()
                }
                mins.add(i)
            }
            return sum
        }

        fun subArrayRangesLoops(nums: IntArray): Long {
            var sum: Long = 0
            val n = nums.size

            for (i in 0..n-1) {
                var curMax = nums[i]
                var curMin = nums[i]

                for (j in i+1..n-1) {
                    curMax = kotlin.math.max(curMax, nums[j])
                    curMin = kotlin.math.min(curMin, nums[j])
                    sum += curMax - curMin
                }
            }

            return sum
        }

        fun subArrayRangesNaive(nums: IntArray): Long {
            var sum: Long = 0
            for (i in nums.indices) {
                for (j in 0..i) {
                    var curMin = nums[i]
                    var curMax = nums[i]
                    for (k in j..i) {
                        curMax = kotlin.math.max(curMax, nums[k])
                        curMin = kotlin.math.min(curMin, nums[k])
                    }
                    sum += kotlin.math.abs(curMax-curMin)
                }
            }
            return sum
        }
    }
}