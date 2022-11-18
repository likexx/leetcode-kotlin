package solution

import solution.annotation.Leetcode
import java.math.BigInteger
import java.util.PriorityQueue

class Solution1201 {
    @Leetcode(1201)
    class Solution {
        fun nthUglyNumber(n: Int, a: Int, b: Int, c: Int): Int {
            fun gcd(a: Long, b: Long): Long {
                if (b == 0L) {
                    return a
                }
                return gcd(b, a%b)
            }

            fun lcm(a: Long, b: Long): Long {
                return (a*b)/gcd(a,b)
            }

            val ab = lcm(a.toLong(), b.toLong())
            val bc = lcm(b.toLong(), c.toLong())
            val ac = lcm(a.toLong(), c.toLong())
            val abc = lcm(a.toLong(), bc.toLong())

            var l = 1L
            var r = (Int.MAX_VALUE-1).toLong()
            while (l<r) {
                val m = l+(r-l)/2
                val total = m/a + m/b + m/c - m/ab - m/bc - m/ac + m/abc
                if (total < n) {
                    l = m+1
                } else {
                    r = m
                }
            }
            return l.toInt()
        }
    }
}