package solution

import solution.annotation.Leetcode

class Solution2128 {
    @Leetcode(2128)
    class Solution {
        fun removeOnes(grid: Array<IntArray>): Boolean {
            val r1 = grid[0]
            val r1Revert = r1.map { kotlin.math.abs(1-it) }.toIntArray()
            for (i in 1..grid.size-1) {
                var matched = true
                for (j in 0..r1.size-1) {
                    if (grid[i][j]!=r1[j]) {
                        matched = false
                        break
                    }
                }
                if (!matched) {
                    matched = true
                    for (j in 0..r1Revert.size-1) {
                        if (grid[i][j]!=r1Revert[j]) {
                            matched = false
                            break
                        }
                    }
                }
                if (!matched) {
                    return false
                }
            }
            return true
        }
    }
}