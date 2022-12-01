package solution

import solution.annotation.Leetcode
import kotlin.math.exp

class Solution1392 {
    @Leetcode(1392)
    class Solution {
        fun longestPrefix(s: String): String {
            val dp = IntArray(s.length) { 0 }
            var len = 0
            var i = 1
            while (i < s.length) {
                if (s[len] == s[i]) {
                    len+=1
                    dp[i] = len
                    i+=1
                } else if (len == 0) {
                    dp[i]=0
                    i+=1
                } else {
                    len = dp[len-1]
                }
            }

            return s.substring(0, dp.last())
        }

        fun longestPrefix_binary(s: String): String {
            val first = s[0]
            val last = s[s.length-1]
            val indexes1 = mutableListOf<Int>()
            val indexes2 = mutableListOf<Int>()

            for (i in 1..s.length-1) {
                if (s[i]==first) {
                    indexes1.add(i)
                }
            }

            for (i in s.length-2 downTo 0) {
                if (s[i]==last) {
                    indexes2.add(i)
                }
            }

            if (indexes2.isEmpty()) {
                return ""
            }

            var maxLen = 0
            for (i in indexes1) {
                val expectLen = s.length - i
                if (expectLen <= maxLen) {
                    break
                }
                var l = 0
                var r = indexes2.size - 1
                while (l<r) {
                    val m = (l+r)/2
                    val curLen = indexes2[m] + 1
                    if (curLen <= expectLen) {
                        r = m
                    } else {
                        l = m+1
                    }
                }

                val curLen = indexes2[l] + 1
                if (curLen == expectLen) {
                    var isSame = true
                    for (k in 0..curLen-1) {
                        if (s[k] != s[i+k]) {
                            isSame = false
                            break
                        }
                    }
                    if (isSame) {
                        maxLen = kotlin.math.max(maxLen, curLen)
                        break
                    }
                }

            }

            return s.substring(0, maxLen)
        }

        fun longestPrefix_Better(s: String): String {
            val first = s[0]
            for (j in 1..s.length-1) {
                if (s[j] != first) {
                    continue
                }

                var i=0
                val len = s.length - j
                var k = 0
                while (k<len && s[i]==s[j+k]) {
                    i+=1
                    k+=1
                }
                if (k==len) {
                    return s.substring(0, k)
                }
            }

            return ""
        }

        fun longestPrefix_Naive(s: String): String {
            var maxLength = 0
            for (l in 1..s.length-1) {
                val prefix = s.substring(0, l)
                val suffix = s.substring(s.length-l, s.length)
                if (prefix == suffix) {
                    maxLength = kotlin.math.max(maxLength, l)
                }
            }
            return s.substring(0, maxLength)
        }
    }
}