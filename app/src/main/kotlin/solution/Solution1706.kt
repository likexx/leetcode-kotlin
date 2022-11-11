package solution

import solution.annotation.Leetcode

class Solution1706 {
    @Leetcode(1706)
    class Solution {
        fun findBall(grid: Array<IntArray>): IntArray {
            val m = grid.size
            val n = grid[0].size
            val result = IntArray(n)

            val blocks = hashSetOf<Pair<Int, Int>>()

            for (i in 0..n-1) {
                val pos= intArrayOf(0,i)
                for (j in 0..m-1) {
                    pos[0]=j
                    val (y,x)=pos
                    if (blocks.contains(Pair(y,x))) {
                        result[i]=-1
                        break
                    }

                    if (x<n-1 && grid[y][x]==1 && grid[y][x+1]==-1) {
                        result[i]=-1
                        blocks.add(Pair(y,x))
                        break
                    } else if (x>0 && grid[y][x]==-1 && grid[y][x-1]==1) {
                        result[i]=-1
                        blocks.add(Pair(y,x))
                        break
                    }

                    when (grid[y][x]) {
                        1 -> pos[1]+=1
                        -1 -> pos[1]-=1
                    }

                    if (pos[1]<0 || pos[1]>=n) {
                        result[i]=-1
                        blocks.add(Pair(y,x))
                        break
                    }
                }

                if (result[i]!=-1) {
                    result[i]=pos[1]
                }
            }
            return result
        }

        fun findBallDP(grid: Array<IntArray>): IntArray {
            val m = grid.size
            val n = grid[0].size
            val dp = mutableListOf<IntArray>()
            for (i in 0..m+1) {
                dp.add(IntArray(n))
            }

            for (j in 0..n-1) {
                dp[m][j]=j
            }

            for (i in m-1 downTo 0) {
                for (j in 0..n-1) {
                    val next = j+grid[i][j]
                    if (next<0 || next>=n || grid[i][j] != grid[i][next]) {
                        dp[i][j]=-1
                    } else {
                        dp[i][j]=dp[i+1][next]
                    }
                }
            }

            val result=IntArray(n)
            for (i in 0..n-1) {
                result[i]=dp[0][i]
            }
            return result
        }

    }
}