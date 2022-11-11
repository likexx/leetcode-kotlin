package solution

import solution.annotation.Leetcode

class Solution1551 {
    @Leetcode(1551)
    class Solution {
        fun minOperations(n: Int): Int {
            val dn = n-1
            val d1 = if (n%2==0) {1} else {0}
            val k = kotlin.math.ceil(n/2.0).toInt()
            return k*(d1+dn)/2
        }

        fun minOperationsLoop(n: Int): Int {
             var i=0
             var j=n-1
             var count=0
             while (i<j) {
                 count+=(j-i)
                 i+=1
                 j-=1
             }
             return count
        }
    }
}