package solution

import solution.annotation.Leetcode

class Solution1143 {
    @Leetcode(1143)
    class Solution {
        fun longestCommonSubsequence(text1: String, text2: String): Int {
            val dp = Array<IntArray>(text1.length + 1) { IntArray(text2.length + 1) {0} }

            for (i in 1..text1.length) {
                for (j in 1..text2.length) {
                    if (text1[i-1] == text2[j-1]) {
                         dp[i][j] = dp[i-1][j-1]+1
                    } else {
                        dp[i][j] = kotlin.math.max(dp[i][j-1], dp[i-1][j])
                    }
                }
            }
            return dp[text1.length][text2.length]
        }
    }
}