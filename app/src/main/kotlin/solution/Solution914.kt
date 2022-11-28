package solution

import solution.annotation.Leetcode

class Solution914 {
    @Leetcode(914)
    class Solution {
        fun hasGroupsSizeX(deck: IntArray): Boolean {
            val count = hashMapOf<Int, Int>()
            deck.forEach { count[it] = count.getOrDefault(it, 0) + 1 }

            fun gcd(a: Int, b: Int): Int {
                if (b==0) {
                    return a
                }
                return gcd(b, a%b)
            }

            val values = count.values.toList()
            if (values.size<2) {
                return values[0]!! > 1
            }

            var g = gcd(values[0], values[1])
            for (i in 2..values.size-1) {
                g = gcd(g, values[i])
            }

            return g!=1
        }

        fun hasGroupsSizeX_Naive(deck: IntArray): Boolean {
            val group = hashMapOf<Int, Int>()
            var maxCount = 0
            for (k in deck) {
                group[k] = group.getOrDefault(k, 0) + 1
                maxCount = kotlin.math.max(maxCount, group[k]!!)
            }

            for (i in 2..maxCount) {
                var canBeDivided = true
                for (v in group.values) {
                    if (v == 1) {
                        return false
                    }
                    if (v%i!=0) {
                        canBeDivided = false
                        break
                    }
                }
                if (canBeDivided) {
                    return true
                }
            }
            return false
        }
    }
}