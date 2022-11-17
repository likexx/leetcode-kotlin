package solution

import solution.annotation.Leetcode

class Solution343 {
    @Leetcode(343)
    class Solution {
        fun integerBreak(n: Int): Int {
            if (n==1 || n==2) {
                return 1
            }

            when (n%3) {
                0 -> {
                    var x=n/3.0
                    return Math.pow(3.0, x).toInt()
                }
                1 -> {
                    return 2*2*Math.pow(3.0,(n-4.0)/3).toInt()
                }
                2-> {
                    return 2*Math.pow(3.0, (n-2.0)/3).toInt()
                }
            }

            return 0
        }
    }
}