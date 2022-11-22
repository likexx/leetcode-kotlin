package solution

import solution.annotation.Leetcode

class Solution279 {
    @Leetcode(279)
    class Solution {
        fun numSquares(n: Int): Int {
            val dp = IntArray(n+1) { it }
            for (i in 4..n) {
                for (j in 1..kotlin.math.sqrt(i.toDouble()).toInt()) {
                    dp[i] = kotlin.math.min(dp[i], 1 + dp[i-j*j])
                }
            }
            return dp[n]
        }

        fun numSquaresNaive(n: Int): Int {
            val cache = hashMapOf<Int, Int>()
            val squares = hashMapOf<Int, Boolean>()

            fun isPerfectSquare(k: Int): Boolean {
                if (k==1) {
                    return true
                }
                if (squares.containsKey(k)) {
                    return squares[k]!!
                }

                val v = kotlin.math.sqrt(k.toDouble())
                val v1 = kotlin.math.floor(v)
                val v2 = kotlin.math.ceil(v)
                squares[k] = v1==v2
                return v1==v2
            }

            fun find(k: Int): Int {
                if (isPerfectSquare(k)) {
                    return 1
                }
                if (cache.containsKey(k)) {
                    return cache[k]!!
                }

                var minCount = k
                for (i in 1..k/2) {
                    if (isPerfectSquare(i) && isPerfectSquare(k-i)) {
                        return 2
                    }
                    minCount = kotlin.math.min(minCount, find(i)+find(k-i))
                }
                cache[k]=minCount
                return minCount
            }

            return find(n)
        }
    }
}