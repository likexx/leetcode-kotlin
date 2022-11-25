package solution

import solution.annotation.Leetcode
import java.util.PriorityQueue
import kotlin.math.pow

class Solution907 {
    @Leetcode(907)
    class Solution {
        fun sumSubarrayMins(arr: IntArray): Int {
            // monotonic stack + dp
            var total = 0L
            val N = arr.size
            val mod = (Math.pow(10.0, 9.0) + 7).toLong()
            val s = mutableListOf<Int>()
            val dp = LongArray(N)

            for (i in 0..N-1) {
                while (s.isNotEmpty() && arr[s.last()]>=arr[i]) {
                    s.removeAt(s.size-1)
                }

                if (s.isNotEmpty()) {
                    dp[i] = dp[s.last()] + (i-s.last())*arr[i].toLong()
                } else {
                    dp[i] = (i+1)*arr[i].toLong() // e.g. for arr[0], dp[0]=arr[0]
                }
                s.add(i)
            }

            dp.forEach { total += it }
            return (total%mod).toInt()
        }

        fun sumSubarrayMins_Stack(arr: IntArray): Int {
            var total = 0L
            val N = arr.size
            val mod = (Math.pow(10.0, 9.0) + 7).toLong()
            val s = mutableListOf<Int>()

            for (i in 0..N) {
                while (s.isNotEmpty() && (i==N || arr[s.last()]>=arr[i])) {
                    val m = s.last()
                    s.removeAt(s.size-1)
                    val left = if (s.isEmpty()) { -1 } else { s.last() }
                    val right = i
                    total += arr[m].toLong()*(m-left)*(right-m)
                }
                s.add(i)
            }

            return (total%mod).toInt()
        }

        fun sumSubarrayMins_SegmentTree(arr: IntArray): Int {
            val N = arr.size
            val tree = IntArray(2*N) { Int.MAX_VALUE }
            for (i in 0..N-1) {
                var j = i+N
                tree[j] = arr[i]
                while (j>1) {
                    j /= 2
                    tree[j] = kotlin.math.min(tree[j*2], tree[j*2+1])
                }
            }

            fun queryMin(i: Int, j: Int): Int {
                var left = i + N
                var right= j + N + 1
                var minValue = kotlin.Int.MAX_VALUE
                while (left < right) {
                    if (left and 1 == 1) {
                        minValue = kotlin.math.min(minValue, tree[left])
                        left += 1
                    }
                    if (right and 1 == 1) {
                        right -= 1
                        minValue = kotlin.math.min(minValue, tree[right])
                    }
                    left /= 2
                    right /= 2
                }
                return minValue
            }

            var result = 0
            val mod = (Math.pow(10.0, 9.0) + 7).toInt()
            for (i in 0..N-1) {
                for (j in i..N-1) {
                    result += queryMin(i, j)
                    result %= mod
                }
            }
            return result
        }
    }
}