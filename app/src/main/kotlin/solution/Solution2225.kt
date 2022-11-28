package solution

import solution.annotation.Leetcode

class Solution2225 {
    @Leetcode(2225)
    class Solution {
        fun findWinners(matches: Array<IntArray>): List<List<Int>> {
            val winners = mutableSetOf<Int>()
            val losers = hashMapOf<Int, Int>()

            for (m in matches) {
                winners.add(m[0])
                losers[m[1]] = losers.getOrDefault(m[1], 0) + 1
            }

            for (k in losers.keys) {
                winners.remove(k)
            }

            val oneLosers = losers.filter { it.value == 1 }.map { it.key }

            return listOf(winners.toList().sorted(), oneLosers.sorted())
        }
    }
}