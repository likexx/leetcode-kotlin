package test

import test.annotation.Leetcode

class Solution2454 {
    @Leetcode(2454)
    class Solution {
        // inspired by https://leetcode.com/problems/next-greater-element-iv/discuss/2756668/JavaC%2B%2BPython-One-Pass-Stack-Solution-O(n)
        fun secondGreaterElement(nums: IntArray): IntArray {
            val result = IntArray(nums.size) {-1}
            val s1 = mutableListOf<Int>()
            val s2 = mutableListOf<Int>()
            val temp = mutableListOf<Int>()

            for ((i,n) in nums.withIndex()) {
                while (s2.size>0 && nums[s2.last()]<n) {
                    val j = s2.last()
                    s2.removeAt(s2.size-1)
                    result[j]=n
                }
                while (s1.size>0 && nums[s1.last()]<n) {
                    val j = s1.last()
                    s1.removeAt(s1.size-1)
                    temp.add(j)
                }
                while (temp.size>0) {
                    val j = temp.last()
                    temp.removeAt(temp.size-1)
                    s2.add(j)
                }
                s1.add(i)
            }

            return result
        }

        fun secondGreaterElementOriginal(nums: IntArray): IntArray {
            val next = IntArray(nums.size) { -1 }
            val maxes = IntArray(nums.size) { -1 }
            maxes[maxes.size-1]=nums[maxes.size-1]

            for (i in nums.size-2 downTo 0) {
                if (nums[i]==nums[i+1]) {
                    next[i]=next[i+1]
                    maxes[i]=maxes[i+1]
                    continue
                }

                maxes[i] = kotlin.math.max(maxes[i+1], nums[i])
                var j = i+1
                while (j<nums.size && j!=-1) {
                    if (nums[j]>nums[i]) {
                        next[i]=j
                        break
                    }
                    j=next[j]
                }
            }
//            println(next.toList())
//            println(maxes.toList())

            val result = IntArray(nums.size) { -1 }
            for (i in 0..nums.size-1) {
                if (i>0 && nums[i-1]==nums[i]) {
                    result[i]=result[i-1]
                    continue
                }

                var j=next[i]
                if (j==-1) {
                    continue
                }
                for (k in j+1..nums.size-1) {
                    if (maxes[k]<=nums[i]) {
                        break
                    }
                    if (nums[k]>nums[i]) {
                        result[i]=nums[k]
                        break
                    }
                }
            }

            return result
        }

        fun secondGreaterElementNaive(nums: IntArray): IntArray {
            val result = IntArray(nums.size) { -1 }
            for (i in 0..nums.size-1) {
                var count=0
                for (j in i+1..nums.size-1) {
                    if (nums[j]>nums[i]) {
                        count+=1
                    }
                    if (count==2) {
                        result[i]=nums[j]
                        break
                    }
                }
            }

            return result
        }

    }
}