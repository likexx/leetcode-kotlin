package test

import test.annotation.Leetcode

class Solution952 {
    @Leetcode(952)
    class Solution {
        fun largestComponentSize(nums: IntArray): Int {
            // use prime factor decomposition
            var maxN = -1
            nums.forEach { maxN = kotlin.math.max(it, maxN) }

            var parents = IntArray(maxN+1) {-1}
            var sizes = IntArray(maxN+1) {1}

            fun findParent(i:Int): Int {
                if (parents[i]==-1) {
                    return i
                }
                parents[i]=findParent(parents[i])
                return parents[i]
            }

            fun union(i: Int, j: Int) {
                val p1 = findParent(i)
                val p2 = findParent(j)
                if (p1 == p2) {
                    return
                }
                val s1 = sizes[p1]
                val s2 = sizes[p2]
                if (s1>=s2) {
                    parents[p2] = p1
                    sizes[p1] += sizes[p2]
                } else {
                    parents[p1] = p2
                    sizes[p2] += sizes[p1]
                }
            }

            fun getPrimeFactors(n: Int): List<Int> {
                val factors = mutableListOf<Int>()
                var factor = 2
                var num = n

                while (num >= factor*factor) {
                    if (num%factor==0) {
                        factors.add(factor)
                        num /= factor
                    } else {
                        factor += 1
                    }
                }
                factors.add(num)
                return factors
            }

            val numberGroups = hashMapOf<Int, Int>()
            nums.forEach {
                val n = it
                var factors = getPrimeFactors(it)
                numberGroups[it] = factors[0]
                for (i in 0..factors.size-2) {
                    union(factors[i], factors[i+1])
                }
            }

            val count = hashMapOf<Int, Int>()
            var maxSize=0
            nums.forEach {
                val k = findParent(numberGroups[it]!!)
                count[k] = count.getOrDefault(k, 0) + 1
                maxSize = kotlin.math.max(count[k]!!, maxSize)
            }

            return maxSize
        }

        fun largestComponentSizeByFactors(nums: IntArray): Int {
            var maxN = -1
            nums.forEach { maxN = kotlin.math.max(it, maxN) }

            var parents = IntArray(maxN+1) {-1}
            var sizes = IntArray(maxN+1) {1}

            fun findParent(i:Int): Int {
                if (parents[i]==-1) {
                    return i
                }
                parents[i]=findParent(parents[i])
                return parents[i]
            }

            fun union(i: Int, j: Int) {
                val p1 = findParent(i)
                val p2 = findParent(j)
                if (p1 == p2) {
                    return
                }
                val s1 = sizes[p1]
                val s2 = sizes[p2]
                if (s1>=s2) {
                    parents[p2] = p1
                    sizes[p1] += sizes[p2]
                } else {
                    parents[p1] = p2
                    sizes[p2] += sizes[p1]
                }
            }

            nums.forEach {
                val n = it
                for (i in 2..kotlin.math.sqrt(n.toDouble()).toInt()) {
                    if (n % i == 0) {
                        union(n, i)
                        union(n, n / i)
                    }
                }
            }

            val count = hashMapOf<Int, Int>()
            var maxSize=0
            nums.forEach {
                val k = findParent(it)
                count[k] = count.getOrDefault(k, 0) + 1
                maxSize = kotlin.math.max(count[k]!!, maxSize)
            }

            return maxSize
        }
    }
}