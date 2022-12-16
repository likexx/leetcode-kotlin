package solution

import solution.annotation.Leetcode

class Solution357 {
    @Leetcode(357)
    class Solution {
        fun countNumbersWithUniqueDigits(n: Int): Int {
            if (n==0) { return 1 }

            var count = 10
            var digits = 9
            var nums = 9
            for (k in 2..n) {
                nums *= digits
                digits -= 1
                count += nums
            }

            return count
        }
    }
}