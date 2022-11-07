package test

import test.annotation.Leetcode

class Solution1323 {
    @Leetcode(1323)
    class Solution {
        fun maximum69Number (num: Int): Int {
            var n = num
            var index = 0
            var highestIndex6 = -1

            while (n>0) {
                if (n%10==6) {
                    highestIndex6=index
                }
                n=n/10
                index+=1
            }

            return if (highestIndex6<0) {num} else {num+3* Math.pow(10.toDouble(), highestIndex6.toDouble()).toInt()}
        }

        fun maximum69NumberOriginal(num: Int): Int {
            val nums = mutableListOf<Int>()
            var n = num
            while (n>0) {
                nums.add(n%10)
                n=n/10
            }

            var result=0
            var updated = false
            for (i in nums.size-1 downTo 0) {
                if (!updated && nums[i]==6) {
                    nums[i]=9
                    updated=true
                }
                result = result*10 + nums[i]
            }

            return result
        }
    }
}