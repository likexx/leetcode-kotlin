package solution

import solution.annotation.Leetcode

class Solution263 {
    @Leetcode(263)
    class Solution {
        fun isUgly(n: Int): Boolean {
            var k = n

            for (d in arrayOf(25,15,10,6,5,3,2)) {
                while (k>=d && k%d==0) {
                    k/=d
                }
            }

            return k==1
        }
    }
}